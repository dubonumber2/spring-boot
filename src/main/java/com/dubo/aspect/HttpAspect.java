package com.dubo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class HttpAspect {


    private final  static Logger logger= LoggerFactory.getLogger(HttpAspect.class);

    /**
     * before注解在方法执行之前执行
     */
    @Pointcut("execution(public * com.dubo.controller.GirlController.*(..))")
    public void log2(){

    }
    @Before("log2()")
    public void log(JoinPoint joinPoint){
       //url
        ServletRequestAttributes attributes=(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=attributes.getRequest();
        logger.info("url={}",request.getRequestURL());
        //ip
        logger.info("ip={}",request.getRemoteAddr());
        //method
        logger.info("method={}",request.getMethod());
        //类方法
        logger.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
        //参数
        logger.info("args={}",joinPoint.getArgs());
    }
    @After("log2()")
    public void log1(){
       logger.info("after love");
    }
}
