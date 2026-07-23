package com.library.aspect;

import org.aspectj.lang.JoinPoint;

public class LoggingAspect {
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("[Aspect Log] Before advice: Executing method " + joinPoint.getSignature().toShortString());
    }

    public void logAfter(JoinPoint joinPoint) {
        System.out.println("[Aspect Log] After advice: Finished executing method " + joinPoint.getSignature().toShortString());
    }
}
