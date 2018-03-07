package com.dubo.handle;


import com.dubo.entity.Result;
import com.dubo.exception.GirlException;
import com.dubo.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {

    private final static Logger logger= LoggerFactory.getLogger(ExceptionHandle.class);
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        if(e instanceof GirlException){
            return ResultUtil.error(((GirlException) e).getCode(),((GirlException) e).getMessage());
        }else{
            logger.error("【系统异常】={}",e);
            return ResultUtil.error(-1,"未知错误");
        }


    }


}
