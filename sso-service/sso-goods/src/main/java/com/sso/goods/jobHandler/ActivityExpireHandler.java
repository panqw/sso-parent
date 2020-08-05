package com.sso.goods.jobHandler;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.XxlJob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Component;


@Component
public class ActivityExpireHandler extends IJobHandler {
    private Logger logger = LoggerFactory.getLogger(ActivityExpireHandler.class);

    @XxlJob("demoJobHandler")
    @Override
    public ReturnT<String> execute(String param) throws Exception {
        ReturnT<String> ret = new ReturnT();
        logger.info("处理失效活动参与信息");
        try {
            ret.setCode(ReturnT.SUCCESS_CODE);
        }catch (Exception e){
            ret.setCode(ReturnT.FAIL_CODE);
        }
        return ret;
    }
}
