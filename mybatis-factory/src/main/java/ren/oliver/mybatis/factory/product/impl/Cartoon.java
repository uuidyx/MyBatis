package ren.oliver.mybatis.factory.product.impl;

import ren.oliver.mybatis.factory.product.Movie;

public class Cartoon implements Movie {

    // 字段很多，构造很复杂

    @Override
    public void watch() {
        System.out.println("Cartoon...watch");
    }

}
