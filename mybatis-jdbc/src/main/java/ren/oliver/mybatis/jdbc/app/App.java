package ren.oliver.mybatis.jdbc.app;

import ren.oliver.mybatis.jdbc.dao.JdbcDao;

// 传统的JDBC
public class App {

    public static void main(String[] args) {
        JdbcDao jdbcDao = new JdbcDao();

        // Query Statement
        System.out.println("Query Statement 测试开始");
        jdbcDao.queryStatement();
        System.out.println("Query Statement 测试结束");


    }

}
