package ren.oliver.mybatis.jdbc.dao;

import ren.oliver.mybatis.jdbc.pojo.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JdbcDao {

    // 数据库驱动
    private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

    // 数据库连接地址
    private final String DB_URL = "jdbc:mysql://localhost:3306/mybatis?useUnicode=true&characterEncoding=utf8&allowMultiQueries=true";

    // 数据库用户
    private final String DB_USER = "root";

    // 数据库密码
    private final String DB_PASS = "123456";

    public void queryStatement() {
        Connection connection = null;
        Statement statement = null;
        List<User> users = new ArrayList<User>();
        try {

            // 注册MySQL驱动
            System.out.println("注册MySQL驱动");
            Class.forName(JDBC_DRIVER);

            // 获得一个连接
            System.out.println("获得一个连接");
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);

            // 创建一个查询
            System.out.println("创建一个查询");
            statement = connection.createStatement();

            String userName = "oliver";
            String sql = "SELECT * FROM t_user where user_name='" + userName + "'";
            System.out.println("SQL语句：" + sql);

            // 执行SQL语句
            ResultSet resultSet = statement.executeQuery(sql);

            // 从resultSet中获取数据并转化成pojo对象
            while (resultSet.next()) {
                User user = new User();
				user.setId(resultSet.getInt("id"));
				user.setUserName(resultSet.getString("user_name"));
                user.setRealName(resultSet.getString("real_name"));
                user.setSex(resultSet.getByte("sex"));
                user.setMobile(resultSet.getString("mobile"));
                user.setEmail(resultSet.getString("email"));
                user.setNote(resultSet.getString("note"));
                System.out.println(user.toString());
                users.add(user);
            }
            // 关闭连接，释放资源
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 确保资源一定被释放
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (connection != null) {
                    connection.close();

                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
