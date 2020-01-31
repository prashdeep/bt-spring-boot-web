package com.bt.itemmgmt.aspects;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.springframework.aop.MethodBeforeAdvice;

public class LoggingAspect implements MethodBeforeAdvice {

    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("Calling the "+method.getName()+ " with arguments: "+Arrays.asList(args)+" on target : "+target);
    }

}
