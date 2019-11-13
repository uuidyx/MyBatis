package ren.oliver.mybatis.factory;

import ren.oliver.mybatis.factory.product.Movie;
import ren.oliver.mybatis.factory.simple.MovieFactory;
import ren.oliver.mybatis.factory.simple.impl.ActionMovieFactory;
import ren.oliver.mybatis.factory.simple.impl.CartoonMovieFactory;
import ren.oliver.mybatis.factory.simple.impl.SimpleMovieFactory;

public class App {

    public static void main(String[] args) {
        // 简单工厂模式
        MovieFactory movieFactory = new SimpleMovieFactory();
        Movie movie = movieFactory.creatMovie("action");
        movie.watch();

        // 普通工厂模式
        movieFactory = new CartoonMovieFactory();
        movie = movieFactory.creatMovie("cartoon");
        movie.watch();
    }

}
