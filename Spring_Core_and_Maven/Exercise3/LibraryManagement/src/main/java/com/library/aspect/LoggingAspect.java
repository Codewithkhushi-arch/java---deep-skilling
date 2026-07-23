package com.library.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

public class LoggingAspect {
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        
        System.out.println("[Aspect Log] Before method execution: " + joinPoint.getSignature().toShortString());
        Object proceed = joinPoint.proceed();
        
        long executionTime = System.currentTimeMillis() - start;
        System.out.println("[Aspect Log] After method execution: " + joinPoint.getSignature().toShortString() + " executed in " + executionTime + "ms");
        
        return proceed;
    }
}
