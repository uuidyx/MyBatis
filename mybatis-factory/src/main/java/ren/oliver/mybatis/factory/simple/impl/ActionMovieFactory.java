package ren.oliver.mybatis.factory.simple.impl;

import ren.oliver.mybatis.factory.product.Movie;
import ren.oliver.mybatis.factory.product.impl.Action;
import ren.oliver.mybatis.factory.simple.MovieFactory;

public class ActionMovieFactory implements MovieFactory {
    @Override
    public Movie creatMovie(String type) {
        Movie movie = new Action();
        return movie;
    }
}
