package ren.oliver.mybatis.factory.simple;

import ren.oliver.mybatis.factory.product.Movie;

/**
 * 优点：客户端免除了直接创建产品对象的责任，而仅仅负责调用，对象创建和对象使用的职责解耦
 * 缺点：不符合设计原则中的单一原则和开闭原则，对于需求的扩展需要修改代码
 * 使用场景：对象比较单一，需求不复杂
 */

public interface MovieFactory {

    Movie creatMovie(String type);

}
