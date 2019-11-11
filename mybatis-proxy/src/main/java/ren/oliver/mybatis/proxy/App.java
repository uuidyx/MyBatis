package ren.oliver.mybatis.proxy;

import ren.oliver.mybatis.proxy.entity.Girl;
import ren.oliver.mybatis.proxy.entity.impl.Cathy;
import ren.oliver.mybatis.proxy.proxy.CathyProxy;

public class App {

    public static void main(String[] args) {
        Girl girl = new Cathy();
        CathyProxy cathyProxy = new CathyProxy(girl);
        Girl cathy = (Girl)cathyProxy.getProxyInstance();
        cathy.date();
    }

}
