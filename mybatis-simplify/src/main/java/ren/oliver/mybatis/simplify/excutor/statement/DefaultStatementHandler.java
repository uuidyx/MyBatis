package ren.oliver.mybatis.simplify.excutor.statement;

import ren.oliver.mybatis.simplify.config.MappedStatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DefaultStatementHandler implements StatementHandler {
	
	private MappedStatement mappedStatment;
	
	
	
	

	public DefaultStatementHandler(MappedStatement mappedStatment) {
		super();
		this.mappedStatment = mappedStatment;
	}

	@Override
	public PreparedStatement prepare(Connection connection) throws SQLException {
		return connection.prepareStatement(mappedStatment.getSql());
	}

	@Override
	public ResultSet query(PreparedStatement statement) {
		try {
			return statement.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
