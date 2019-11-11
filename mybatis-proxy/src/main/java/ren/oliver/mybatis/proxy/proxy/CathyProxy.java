package ren.oliver.mybatis.proxy.proxy;

import ren.oliver.mybatis.proxy.entity.Girl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class CathyProxy implements InvocationHandler {

    private Girl girl;

    public CathyProxy(Girl girl) {
        super();
        this.girl = girl;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object ret = method.invoke(girl, args);
        after();
        return ret;
    }

    private void before() {
        System.out.println("CathyProxy...before");
    }

    private void after() {
        System.out.println("CathyProxy...after");
    }

    public Object getProxyInstance() {
        return Proxy.newProxyInstance(girl.getClass().getClassLoader(), girl.getClass().getInterfaces(), this);
    }

}
