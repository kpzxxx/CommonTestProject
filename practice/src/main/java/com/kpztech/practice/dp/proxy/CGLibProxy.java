package com.kpztech.practice.dp.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CGLibProxy implements MethodInterceptor {
    private Object targetObject;

    public Object createProxyObject(Object targetObject) {
        this.targetObject = targetObject;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(targetObject.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        Object object;
        if (method.getName().equals("addUser")) {
            boolean b = authCheck();
        }
        object = method.invoke(targetObject, objects);
        return object;
    }

    private boolean authCheck() {
        return true;
    }
}
