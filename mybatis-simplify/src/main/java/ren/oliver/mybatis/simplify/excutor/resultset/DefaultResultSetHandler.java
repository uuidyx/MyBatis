package ren.oliver.mybatis.simplify.excutor.resultset;

import ren.oliver.mybatis.simplify.config.MappedStatement;
import ren.oliver.mybatis.simplify.reflection.ReflectionUtil;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DefaultResultSetHandler implements ResultSetHandler {

	private MappedStatement mappedStament;
	
	public DefaultResultSetHandler(MappedStatement mappedStament) {
		super();
		this.mappedStament = mappedStament;
	}

	@Override
	public <E> List<E> handleResultSets(ResultSet resultSet) throws SQLException {
		List<E> ret = new ArrayList<E>();
		while (resultSet.next()) {
			Class<?> entityClass;
			try {
				entityClass = Class.forName(mappedStament.getResultType());
				E entity = (E) entityClass.newInstance();
				Field[] declaredFields = entityClass.getDeclaredFields();
				for (int i = 0; i < declaredFields.length; i++) {
					if(declaredFields[i].getType().getSimpleName().equals("String")){
						ReflectionUtil.setPropToBean(entity, declaredFields[i].getName(), resultSet.getString(declaredFields[i].getName()));
					}else if(declaredFields[i].getType().getSimpleName().equals("Integer")){
						ReflectionUtil.setPropToBean(entity, declaredFields[i].getName(), resultSet.getInt(declaredFields[i].getName()));
					}
				}
				ret.add(entity);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return ret;
	}

}
