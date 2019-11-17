package ren.oliver.mybatis.learning.mapper;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import ren.oliver.mybatis.learning.pojo.Role;

import java.io.InputStream;
import java.util.List;

public class RoleMapperTest {

    SqlSessionFactory sqlSessionFactory;

    @Before
    public void before() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 读取MyBatis配置文件创建SqlSessionFactory
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        inputStream.close();
    }

    @Test
    public void selectRoleUserTest() {
        // 获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 获取对应mapper
        RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
        // 执行查询语句并返回结果
        List<Role> roles = roleMapper.selectRoleUser();
        System.out.println(roles.size());
    }

}
