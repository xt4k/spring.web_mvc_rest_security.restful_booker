package com.yuriy.spring.web_mvc_rest_security.restful_booker.aspect;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import static java.lang.System.*;

@Component
@Aspect
@Slf4j
public class Logging {

    @Around("execution (* com.yuriy.spring.web_mvc_rest_security.restful_booker.controller.*.*(..))")
    public Object aroundAllRepoMethodsAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        String methodName = methodSignature.getName();
        long start =currentTimeMillis();

        log.info("Aspect logging: Started method: " + methodName);

        Object targetMethodResult = joinPoint.proceed();
        long duration = currentTimeMillis() - start;

        log.info(String.format("Aspect logging: Completed method: %s. it worked for:'%s' ms.", methodName,duration));
        return targetMethodResult;
    }
}
