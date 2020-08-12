package com.sso.common.exception;

import com.sso.common.entity.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;

/**
 * @author panqw
 * @date 2020/8/12 17:14
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 主动throw的异常
     *
     * @param e
     * @param response
     * @return
     */
    @ExceptionHandler(GlobalExecption.class)
    public Result handleUnProccessableServiceException(GlobalExecption e, HttpServletResponse response) {
        log.error("服务端异常",e);
        Result result = new Result();
        result.setFlag(false);
        result.setCode(500);
        StringBuffer message = new StringBuffer();
        if(StringUtils.isNotBlank(e.getCode())){
            message.append("异常码：");
            message.append(e.getCode());
        }
        if(StringUtils.isNotBlank(e.getMessage())){
            if(StringUtils.isNotBlank(message.toString())){
                message.append("-");
                message.append(e.getMessage());
            }else{
                message.append(e.getMessage());
            }
        }
        result.setMessage(message.toString());
        return result;
    }

    /**
     * 处理
     *
     * @param e
     * @param response
     * @return
     */
    @ExceptionHandler(Exception.class)
    public Result handleViolationException(Exception e, HttpServletResponse response) {
        log.error("服务端异常",e);
        Result result = new Result();
        result.setFlag(false);
        result.setCode(500);
        result.setMessage(e.getMessage());
        return result;
    }

}
