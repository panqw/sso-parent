package com.sso.goods.service.impl;

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
import com.sso.goods.entity.command.GoodsCommand;
import com.sso.goods.entity.search.GoodsSearch;
import com.sso.goods.service.SkuService;
import com.sso.goods.service.SpuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

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
