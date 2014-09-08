package com.hp.manner.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component("loggingAspect")
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Pointcut("execution(* com.hp.manner.service..*.*(..))")
    private void selectAll(){}

    @Before("selectAll()")
    public void beforeAdvice(JoinPoint joinPoint){
        //logger.debug("beforeAdvice() is running");
        logger.info("before executing method: " + joinPoint.getSignature());
    }

    @After("selectAll()")
    public void afterAdvice(JoinPoint joinPoint){
        //logger.debug("afterAdvice() is running");
        logger.info("after executing method: " + joinPoint.getSignature());
    }


}
