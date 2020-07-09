package com.a3test.component.authorizationtransmitter;

import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestVariableDefault;

/**
 * @author eason
 *
 */
public class AuthorizationHolder {
    private static final HystrixRequestVariableDefault<Authorization> AUTHORIZATION = new HystrixRequestVariableDefault<>();

    public static Authorization get() {
        initializeContext();
        return AUTHORIZATION.get();
    }

    public static void set(Authorization authorization) {
        initializeContext();
        AUTHORIZATION.set(authorization);
    }

    public static void shutdown() {
        if (HystrixRequestContext.isCurrentThreadInitialized()) {
            HystrixRequestContext.getContextForCurrentThread().shutdown();
        }
    }

    private static void initializeContext() {
        if (!HystrixRequestContext.isCurrentThreadInitialized()) {
            HystrixRequestContext.initializeContext();
        }
    }
}
