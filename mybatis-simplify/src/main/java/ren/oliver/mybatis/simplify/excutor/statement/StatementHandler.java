package ren.oliver.mybatis.simplify.excutor.statement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// Executor实现的基础；功能包括：创建statement对象，为sql语句绑定参数，执行增删改查等SQL语句、将结果映射集进行转化
public interface StatementHandler {

    // 从连接中获取一个Statement
    PreparedStatement prepare(Connection connection) throws SQLException;

    // 执行select语句
    ResultSet query(PreparedStatement statement);

}
