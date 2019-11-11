package ren.oliver.mybatis.proxy.entity.impl;

import ren.oliver.mybatis.proxy.entity.Girl;

public class Cathy implements Girl {

    @Override
    public void date() {
        System.out.println("Cathy...date()");
        this.watchMovie();
    }

    @Override
    public void watchMovie() {
        System.out.println("Cathy...watchMovie()");
    }

}
