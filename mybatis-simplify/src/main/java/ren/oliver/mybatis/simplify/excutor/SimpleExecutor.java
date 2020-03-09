package ren.oliver.mybatis.simplify.excutor;

import ren.oliver.mybatis.simplify.config.Configuration;
import ren.oliver.mybatis.simplify.config.MappedStatement;
import ren.oliver.mybatis.simplify.excutor.parameter.DefaultParameterHandler;
import ren.oliver.mybatis.simplify.excutor.parameter.ParameterHandler;
import ren.oliver.mybatis.simplify.excutor.resultset.DefaultResultSetHandler;
import ren.oliver.mybatis.simplify.excutor.resultset.ResultSetHandler;
import ren.oliver.mybatis.simplify.excutor.statement.DefaultStatementHandler;
import ren.oliver.mybatis.simplify.excutor.statement.StatementHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SimpleExecutor implements Executor {
	
	private Configuration conf;

	public SimpleExecutor(Configuration conf) {
		this.conf = conf;
	}

	public <E> List<E> query(MappedStatement ms, Object parameter) throws SQLException {
		// 获取mappedStatement对象，里面包含sql语句和目标对象等信息；
		MappedStatement mappedStatement = conf.getMappedStatement(ms.getSourceId());
		// 获取Connection对象
		Connection conn = getConnect();
		// 实例化StatementHandler对象，准备实例化Statement
		StatementHandler statementHandler = new DefaultStatementHandler(mappedStatement);
		// 通过statementHandler和Connection获取PreparedStatement
		PreparedStatement prepare = statementHandler.prepare(conn);
		// 实例化ParameterHandler对象，对Statement中sql语句的占位符进行处理
		ParameterHandler parameterHandler = new DefaultParameterHandler(parameter);
		parameterHandler.setParameters(prepare);
		// 执行查询语句，获取结果集resultSet
		ResultSet resultSet = statementHandler.query(prepare);
		// 实例化ResultSetHandler对象，对resultSet中的结果集进行处理，转化成目标对象
		ResultSetHandler resultSetHandler = new DefaultResultSetHandler(mappedStatement);
		return resultSetHandler.handleResultSets(resultSet);
	}

	private Connection getConnect() {
		Connection conn =null;
		try {
			Class.forName(conf.getDbDriver());
			conn = DriverManager.getConnection(conf.getDbUrl(), conf.getDbUserName(), conf.getDbPassword());	
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public Configuration getConf() {
		return conf;
	}

	public void setConf(Configuration conf) {
		this.conf = conf;
	}

}
