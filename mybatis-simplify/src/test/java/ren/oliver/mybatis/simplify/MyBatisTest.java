package ren.oliver.mybatis.simplify;

import org.junit.Test;
import ren.oliver.mybatis.simplify.entity.User;
import ren.oliver.mybatis.simplify.mapper.UserMapper;
import ren.oliver.mybatis.simplify.session.SqlSession;
import ren.oliver.mybatis.simplify.session.SqlSessionFactory;

import java.util.List;

public class MyBatisTest {

    @Test
	public void mybatisTest() {
		// 实例化SqlSessionFactory，加载数据库配置文件以及mapper.xml文件到configuration对象
		SqlSessionFactory factory = new SqlSessionFactory();
		// 获取sqlsession对象
		SqlSession session = factory.openSession();
		// 通过动态代理跨越面向接口编程和ibatis编程模型的鸿沟
		UserMapper userMapper = session.getMapper(UserMapper.class);
		// 遵循jdbc规范，通过底层的四大对象的合作完成数据查询和数据转化
		User user = userMapper.selectByPrimaryKey(1);
		System.out.println(user);
		// 多条查询
		List<User> users = userMapper.selectAll();
		for (User tUser : users) {
			System.out.println(tUser);
		}
	}

}
