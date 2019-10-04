package ren.oliver.mybatis.jdbc.dao;

import ren.oliver.mybatis.jdbc.pojo.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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

        List<User> users = new ArrayList<>();
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

            // 创建SQL
            String userName = "oliver";
            String sql = "SELECT * FROM t_user where user_name='" + userName + "'";
            // 打印SQL
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

    public void queryPreparedStatement() {

        Connection conn = null;
        PreparedStatement stmt = null;

        List<User> users = new ArrayList<>();
        try {

            // 注册MySQL驱动
            System.out.println("注册MySQL驱动");
            Class.forName(JDBC_DRIVER);

            // 获得一个连接
            System.out.println("获得一个连接");
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);

            // 创建一个查询
            System.out.println("创建一个查询");
            // 创建SQL
            String sql = "SELECT * FROM t_user where user_name= ? ";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, "oliver");
            // 打印SQL
            System.out.println("SQL: " + stmt.toString());
            ResultSet rs = stmt.executeQuery();

            // 从resultSet中获取数据并转化成pojo对象
            while (rs.next()) {
                User user = new User();
				user.setId(rs.getInt("id"));
				user.setUserName(rs.getString("user_name"));
                user.setRealName(rs.getString("real_name"));
                user.setSex(rs.getByte("sex"));
                user.setMobile(rs.getString("mobile"));
                user.setEmail(rs.getString("email"));
                user.setNote(rs.getString("note"));
                System.out.println(user.toString());
                users.add(user);
            }

            // 关闭连接，释放资源
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 确保资源一定被释放
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // 打印查询结果数量
        System.out.println("查询到的总用户数：" + users.size());
    }

    public void updateStatement() {

        Connection conn = null;
        PreparedStatement stmt = null;

        try {

            // 注册MySQL的驱动
            System.out.println("注册MySQL的驱动");
            Class.forName(JDBC_DRIVER);

            // 获得一个连接
            System.out.println("获得一个连接");
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);

            // 启动手动提交
            conn.setAutoCommit(false);

            // 创建一个更新
            System.out.println("创建一个更新");
            String sql = "update t_user  set mobile= ? where user_name= ? ";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, "18999999999");
            stmt.setString(2, "oliver");
            // 打印SQL
            System.out.println(stmt.toString());
            // 执行SQL
            int ret = stmt.executeUpdate();
            System.out.println("此次修改影响数据库的行数为：" + ret);

            // 手动提交数据
            conn.commit();

            // 关闭连接，释放资源
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            try {
                conn.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            se.printStackTrace();
        } catch (Exception e) {
            try {
                conn.rollback();
            } catch (SQLException se) {
                se.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            // 确保资源一定被释放
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
