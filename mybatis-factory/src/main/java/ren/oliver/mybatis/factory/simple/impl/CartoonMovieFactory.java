package ren.oliver.mybatis.factory.simple.impl;

import ren.oliver.mybatis.factory.product.Movie;
import ren.oliver.mybatis.factory.product.impl.Cartoon;
import ren.oliver.mybatis.factory.simple.MovieFactory;

public class CartoonMovieFactory implements MovieFactory {

    @Override
    public Movie creatMovie(String type) {
        Movie movie = new Cartoon();
        return movie;
    }

}
