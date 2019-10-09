package ren.oliver.mybatis.learning.mapper;

import ren.oliver.mybatis.learning.pojo.EmailSexBean;
import ren.oliver.mybatis.learning.pojo.User;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserMapperTest {

    @Test
    public void deleteByPrimaryKeyTest() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 读取MyBatis配置文件创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        inputStream.close();
        // 获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 获取对应mapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 执行查询语句并返回结果
        userMapper.deleteByPrimaryKey(1);
    }

    @Test
    public void insert1Test() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 读取MyBatis配置文件创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        inputStream.close();
        // 获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 获取对应mapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 执行查询语句并返回结果
        User user = new User();
        user.setUserName("oliver-csu");
        user.setRealName("Oliver King");
        user.setSex(new Byte("1"));
        user.setEmail("oliver.csu@gmail.com");
        userMapper.insert1(user);
    }

    @Test
    public void insert2Test() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 读取MyBatis配置文件创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        inputStream.close();
        // 获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 获取对应mapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 执行查询语句并返回结果
        User user = new User();
        user.setUserName("oliver-csu");
        user.setRealName("Oliver King");
        user.setSex(new Byte("1"));
        user.setEmail("oliver.csu@gmail.com");
        userMapper.insert2(user);
    }

    @Test
    public void insertSelectiveTest() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 读取MyBatis配置文件创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        inputStream.close();
        // 获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 获取对应mapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 执行查询语句并返回结果
        User user = new User();
        user.setUserName("oliver-csu");
        user.setRealName("Oliver King");
        user.setSex(new Byte("1"));
        user.setEmail("oliver.csu@gmail.com");
        userMapper.insertSelective(user);
    }

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
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 执行查询语句并返回结果
        User user = userMapper.selectByPrimaryKey(1);
        System.out.println(user.toString());
    }

    @Test
    public void updateByPrimaryKeySelectiveTest() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 读取MyBatis配置文件创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        inputStream.close();
        // 获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 获取对应mapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 执行查询语句并返回结果
        User user = new User();
        user.setUserName("oliver-csu");
        user.setRealName("Oliver King");
        user.setSex(new Byte("1"));
        user.setEmail("oliver.csu@gmail.com");
        userMapper.updateByPrimaryKeySelective(user);
    }

    @Test
    public void updateByPrimaryKeyTest() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 读取MyBatis配置文件创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        inputStream.close();
        // 获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 获取对应mapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 执行查询语句并返回结果
        User user = new User();
        user.setUserName("oliver-csu");
        user.setRealName("Oliver King");
        user.setSex(new Byte("1"));
        user.setEmail("oliver.csu@gmail.com");
        userMapper.updateByPrimaryKey(user);
    }

    @Test
    public void selectUserJobs1Test() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 读取MyBatis配置文件创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        inputStream.close();
        // 获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 获取对应mapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 执行查询语句并返回结果
        List<User> users = userMapper.selectUserJobs1();
        System.out.println(users.toString());
    }

    @Test
    public void selectUserJobs2Test() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 读取MyBatis配置文件创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        inputStream.close();
        // 获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 获取对应mapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 执行查询语句并返回结果
        List<User> users = userMapper.selectUserJobs2();
        System.out.println(users.toString());
    }

    @Test
    public void selectByEmailAndSex1Test() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 读取MyBatis配置文件创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        inputStream.close();
        // 获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 获取对应mapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 执行查询语句并返回结果
        String email = "qq.com";
        Byte sex = 1;
        Map<String, Object> param = new HashMap<>();
        param.put("email", email);
        param.put("sex", sex);
        List<User> users = userMapper.selectByEmailAndSex1(param);
        System.out.println(users.toString());
    }

    @Test
    public void selectByEmailAndSex2Test() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 读取MyBatis配置文件创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        inputStream.close();
        // 获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 获取对应mapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 执行查询语句并返回结果
        String email = "qq.com";
        Byte sex = 1;
        List<User> users = userMapper.selectByEmailAndSex2(email, sex);
        System.out.println(users.toString());
    }

    @Test
    public void selectByEmailAndSex3Test() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 读取MyBatis配置文件创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        inputStream.close();
        // 获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 获取对应mapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 执行查询语句并返回结果
        String email = "qq.com";
        Byte sex = 1;
        EmailSexBean emailSexBean = new EmailSexBean();
        emailSexBean.setEmail(email);
        emailSexBean.setSex(sex);
        List<User> users = userMapper.selectByEmailAndSex3(emailSexBean);
        System.out.println(users.toString());
    }

}
