package com.kpztech.practice.dp.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKProxy implements InvocationHandler {
    private Object targetObject;

    public Object newProxy(Object targetObject) {
        this.targetObject = targetObject;
        return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(), targetObject.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        boolean b = authCheck();
        if (!b) {
            return null;
        }
        Object ret;
        ret = method.invoke(targetObject, args);
        return ret;
    }

    private boolean authCheck() {
        return true;
    }
}
