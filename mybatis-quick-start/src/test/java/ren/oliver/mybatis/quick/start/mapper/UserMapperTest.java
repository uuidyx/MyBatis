package ren.oliver.mybatis.quick.start.mapper;

import ren.oliver.mybatis.quick.start.pojo.User;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

public class UserMapperTest {

    SqlSessionFactory sqlSessionFactory;

    SqlSession sqlSession;

    @Before
    public void init() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 读取MyBatis配置文件创建SqlSessionFactory
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        inputStream.close();
        // 获取SqlSession
        sqlSession = sqlSessionFactory.openSession();
    }

    @Test
    public void selectByPrimaryKeyTest() {
        // 获取对应mapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // 执行查询语句并返回结果
        User user = mapper.selectByPrimaryKey(1);
        System.out.println(user.toString());
    }

    @Test
    public void selectOriginTest() {
        // 直接使用SqlSession执行查询语句并返回结果
        User user = sqlSession.selectOne("ren.oliver.mybatis.quick.start.mapper.UserMapper.selectByPrimaryKey",1);
        System.out.println(user.toString());
    }

}
