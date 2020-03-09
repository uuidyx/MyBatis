package ren.oliver.mybatis.simplify.session;

import ren.oliver.mybatis.simplify.config.Configuration;
import ren.oliver.mybatis.simplify.config.MappedStatement;
import ren.oliver.mybatis.simplify.excutor.Executor;
import ren.oliver.mybatis.simplify.excutor.SimpleExecutor;

import java.sql.SQLException;
import java.util.List;

public class DefaultSqlSession implements SqlSession {
	
	// 配置对象全局唯一 加载数据库信息和mapper文件信息
	private Configuration conf;
	
	// 真正提供数据库访问能力的对象
	private Executor executor;

	public DefaultSqlSession(Configuration conf) {
		super();
		this.conf = conf;
		executor = new SimpleExecutor(conf);
	}

	public <T> T selectOne(String statement, Object parameter) {
		List<Object> selectList = this.selectList(statement, parameter);
		if(selectList!=null && selectList.size()>0){
			return (T) selectList.get(0);
		}
		return null;
	}

	public <E> List<E> selectList(String statement, Object parameter) {
		MappedStatement mappedStatement = conf.getMappedStatement(statement);
		try {
			return executor.query(mappedStatement, parameter);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	  @Override
	  // 获取当前mapper接口的动态代理
	  public <T> T getMapper(Class<T> type) {
	    return conf.getMapper(type, this);
	  }

}
