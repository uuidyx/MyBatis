package ren.oliver.mybatis.factory;

import ren.oliver.mybatis.factory.product.Movie;
import ren.oliver.mybatis.factory.simple.MovieFactory;
import ren.oliver.mybatis.factory.simple.impl.SimpleMovieFactory;

public class App {

    public static void main(String[] args) {
        MovieFactory movieFactory = new SimpleMovieFactory();
        Movie movie = movieFactory.creatMovie("action");
        movie.watch();
    }

}
