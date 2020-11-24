package com.njesoft.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LoggerAspect {
    private static Logger logger = Logger.getLogger(LoggerAspect.class);

    @Pointcut("execution(* com.njesoft.*.*.*(..))")
    private void generalPointcut() {

    }

    @AfterThrowing(value = "generalPointcut() throws Exception" , throwing = "ex")
    private void exceptionLog(JoinPoint joinPoint, Exception ex) throws Exception{
        logger.error(joinPoint.getTarget().getClass().getSimpleName() + " : " + joinPoint.getSignature().getName()+ " : " +ex.getMessage());

    }

    @Before("generalPointcut()")
    public void infoLog(JoinPoint joinPoint) {
        logger.info(joinPoint.getTarget().getClass().getSimpleName() + " : " + joinPoint.getSignature().getName());
    }
}
