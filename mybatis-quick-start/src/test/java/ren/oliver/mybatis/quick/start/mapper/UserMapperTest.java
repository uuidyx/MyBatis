package ren.oliver.mybatis.quick.start.mapper;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import ren.oliver.mybatis.quick.start.pojo.User;

import java.io.IOException;
import java.io.InputStream;

public class UserMapperTest {

    @Test
    public void selectByPrimaryKeyTest() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 读取MyBatis配置文件创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        inputStream.close();
        // 获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 获取对应mapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // 执行查询语句并返回结果
        User user = mapper.selectByPrimaryKey(1);
        System.out.println(user.toString());
    }

}
