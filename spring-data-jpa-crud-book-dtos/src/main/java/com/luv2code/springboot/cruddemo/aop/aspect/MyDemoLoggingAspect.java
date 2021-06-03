package com.luv2code.springboot.cruddemo.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class MyDemoLoggingAspect {

    private  static Logger myLogger=Logger.getLogger(MyDemoLoggingAspect.class.getName());

    @After("execution( * com.luv2code.springboot.cruddemo.service.*.*(..))")
    public void forServicePackage( JoinPoint theJoinPoint)  {
        //print out method we are advising on
        String method=theJoinPoint.getSignature().toShortString();
        myLogger.info("\n ========>>>>Executing @After on method: "+method);

    }

}
