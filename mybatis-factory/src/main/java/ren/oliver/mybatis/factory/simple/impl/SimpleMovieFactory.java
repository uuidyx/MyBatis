package ren.oliver.mybatis.factory.simple.impl;

import ren.oliver.mybatis.factory.product.Movie;
import ren.oliver.mybatis.factory.product.impl.Action;
import ren.oliver.mybatis.factory.product.impl.Cartoon;
import ren.oliver.mybatis.factory.simple.MovieFactory;

public class SimpleMovieFactory implements MovieFactory {

    @Override
    public Movie creatMovie(String type) {
        Movie movie;
        if (type.equals("action")) {
            movie = new Action();
        } else {
            movie = new Cartoon();
        }
        return movie;
    }

}
