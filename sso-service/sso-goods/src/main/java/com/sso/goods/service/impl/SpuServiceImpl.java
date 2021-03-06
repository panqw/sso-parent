package com.sso.goods.service.impl;

import com.github.pagehelper.PageHelper;
import com.sso.common.entity.PageResult;
import com.sso.common.entity.Result;
import com.sso.common.entity.StatusCode;
import com.sso.common.enums.DeleteEnum;
import com.sso.common.enums.GoodsAuditStatus;
import com.sso.common.enums.GoodsOnlineStatus;
import com.sso.common.exception.GlobalExecption;
import com.sso.common.utils.BeanUtils;
import com.sso.goods.common.SnowflakeIdWork;
import com.sso.goods.dao.SkuMapper;
import com.sso.goods.entity.Sku;
import com.sso.goods.entity.Spu;
import com.sso.goods.dao.SpuMapper;
import com.sso.goods.entity.command.CommentCommand;
import com.sso.goods.entity.command.GoodsCommand;
import com.sso.goods.entity.search.GoodsSearch;
import com.sso.goods.entity.vo.CommentVo;
import com.sso.goods.service.SkuService;
import com.sso.goods.service.SpuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author panqw
 * @since 2020-06-01
 */
@Slf4j
@Service
public class SpuServiceImpl extends ServiceImpl<SpuMapper, Spu> implements SpuService {

   @Autowired
   private SpuMapper spuMapper;

   @Autowired
   private SkuMapper skuMapper;

   @Autowired
   private SkuService skuService;

   @Autowired
   private SnowflakeIdWork snowflakeId;
   @Autowired
   private RedisTemplate redisTemplate;

    /**
     * 新增商品
     * @param command
     * @return
     */
    @Transactional
    @Override
    public Result addGoods(GoodsCommand command) {

        try {
            //生成spu
            Long spuId = this.generateGoodsSpu(command);
            //生成sku
            this.generateGoodsSku(spuId,command);
        } catch (Exception e) {
            log.info(e.toString());
            throw new GlobalExecption(e.toString());
        }

        return new Result(true, StatusCode.OK,"商品增加成功");

    }

    @Override
    public PageResult findGoodsList(GoodsSearch search) {

        spuMapper.findGoodsList(search);
        return null;
    }

    /**
     *
     * @param searchParam
     * @param userId
     */
    @Override
    public void search(String searchParam, String userId) {
        //获取搜索内容的分数值看是否在redis中
        Double score = redisTemplate.boundZSetOps("search:" + userId).score(searchParam);
        //如果存在就删除redis中的值
        if (null!= score){
            redisTemplate.boundZSetOps("search:" + userId).remove(searchParam);
        }

        redisTemplate.boundZSetOps("search:" + userId).add(searchParam,System.currentTimeMillis());
        redisTemplate.expire("search:" + userId,10, TimeUnit.DAYS);
        //查一下redis中的总数，超过阈值就删除

        Long size = redisTemplate.boundZSetOps("search:" + userId).size();
        if (size>10){
            redisTemplate.boundZSetOps("search:" + userId).removeRange(10,size-10);
        }

    }

    @Override
    public List<String> getSearch(String userId) {
        //获取搜索历史集合
        Set<ZSetOperations.TypedTuple> set = redisTemplate.boundZSetOps("search:" + userId).rangeWithScores(0, 10);

        List<String> list1 = set.stream().map(o -> o.getValue().toString()).collect(Collectors.toList());

        return list1;
    }

    /**
     * 添加评论
     * @param command
     */
    @Override
    public void addComment(CommentCommand command) {
        command.setCommentId(String.valueOf(System.currentTimeMillis()));
        redisTemplate.boundZSetOps("comment:"+command.getSpuId()).add(command,System.currentTimeMillis());
        redisTemplate.expire("comment:"+command.getSpuId(),1,TimeUnit.DAYS);
    }

    @Override
    public List<CommentVo> getComment(CommentCommand command) {
        //获取redis中的评论列表
        Set<CommentCommand> comments = redisTemplate.boundZSetOps("comment:" + command.getSpuId()).range((command.getPage() - 1) * command.getSize(), command.getPage() * command.getSize() - 1);

        List<CommentVo> commentVoList = BeanUtils.copyList(new ArrayList<>(comments), CommentVo.class);

        return getCommentVoList(commentVoList);
    }

    private List<CommentVo> getCommentVoList(List<CommentVo> commentVoList){
        List<CommentVo> list = new ArrayList<>();
        for (CommentVo commentVo : commentVoList) {
            if (StringUtils.isBlank(commentVo.getParentId())){
                list.add(buildChildren(commentVo,commentVoList));
            }
        }
        return list;
    }

    private CommentVo buildChildren(CommentVo current, List<CommentVo> nodes) {
        for (CommentVo node : nodes) {
            if (StringUtils.equals(current.getCommentId(), node.getParentId())) {
                if (null == current.getCommentVoList()) {
                    current.setCommentVoList(new ArrayList<>());
                }
                current.getCommentVoList().add(buildChildren(node, nodes));
            }
        }
        return current;
    }

    private Long generateGoodsSpu(GoodsCommand command) {
        Spu spu = BeanUtils.copyProperties(command, Spu.class);
        Long spuId = snowflakeId.nextId();
        spu.setId(spuId);
        spu.setIsDeleted(DeleteEnum.NOT_DELETE.getVal());
        spu.setCreateBy("PQW");
        spu.setUpdateBy("PQW");
        Date nowDate = new Date();
        spu.setCreateTime(nowDate);
        spu.setUpdateTime(nowDate);
        spu.setStatus(GoodsAuditStatus.WAIT_AUDIT.getStatus());
        spu.setIsMarketable(GoodsOnlineStatus.OFFONLINE.getStatus());

        spuMapper.insert(spu);
        return spuId;
    }

    private void generateGoodsSku(Long spuId, GoodsCommand command) {
        List<Sku> skuList = command.getSkuList();
        skuList.forEach(sku -> sku.setId(snowflakeId.nextId())
                    .setStatus(GoodsOnlineStatus.OFFONLINE.getStatus())
                    .setSpuId(spuId).setCreateTime(LocalDateTime.now())
                    .setUpdateTime(LocalDateTime.now())
                    .setCategoryId(command.getCategory3Id())
                    );
        skuService.saveBatch(skuList);
    }
}
