package ren.oliver.mybatis.simplify.excutor;

import ren.oliver.mybatis.simplify.config.MappedStatement;

import java.sql.SQLException;
import java.util.List;

// MyBaits核心接口之一，定义了数据库操作最基本的方法，SqlSession的功能都是基于它来实现的
public interface Executor {

    <E> List<E> query(MappedStatement ms, Object parameter) throws SQLException;

}
