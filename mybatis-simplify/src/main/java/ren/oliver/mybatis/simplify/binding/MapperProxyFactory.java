package ren.oliver.mybatis.simplify.binding;

import ren.oliver.mybatis.simplify.session.SqlSession;

import java.lang.reflect.Proxy;

// mapper接口生成动态代理的工程类
public class MapperProxyFactory<T> {

  public static <T> T getMapperProxy(SqlSession sqlSession, Class<T> mapperInterface){
	  MapperProxy<T> mapperProxy = new MapperProxy<T>(sqlSession, mapperInterface);
	  return (T) Proxy.newProxyInstance(mapperInterface.getClassLoader(), new Class[] { mapperInterface }, mapperProxy);
  }

}
