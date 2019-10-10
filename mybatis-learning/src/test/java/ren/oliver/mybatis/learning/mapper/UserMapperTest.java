package ren.oliver.mybatis.learning.mapper;

import org.junit.Before;
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
    public void deleteByPrimaryKeyTest() {
        // 获取对应mapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 执行查询语句并返回结果
        userMapper.deleteByPrimaryKey(1);
    }

    @Test
    public void insert1Test() {
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
    public void insert2Test() {
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
    public void insertSelectiveTest() {
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
    public void selectByPrimaryKeyTest() {
        // 获取对应mapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 执行查询语句并返回结果
        User user = userMapper.selectByPrimaryKey(1);
        System.out.println(user.toString());
    }

    @Test
    public void updateByPrimaryKeySelectiveTest() {
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
    public void updateByPrimaryKeyTest() {
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
    public void selectUserJobs1Test() {
        // 获取对应mapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 执行查询语句并返回结果
        List<User> users = userMapper.selectUserJobs1();
        System.out.println(users.toString());
    }

    @Test
    public void selectUserJobs2Test() {
        // 获取对应mapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 执行查询语句并返回结果
        List<User> users = userMapper.selectUserJobs2();
        System.out.println(users.toString());
    }

    @Test
    public void selectByEmailAndSex1Test() throws Exception {
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

    @Test
    public void selectBySymbolTest() {
        // 获取对应mapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 执行查询语句并返回结果
        String inCol = "id, user_name, real_name, sex, mobile, email, note";
        String tableName = "t_user";
        Byte sex = 1;
        String orderStr = "sex,user_name";
        List<User> users = userMapper.selectBySymbol(tableName, inCol, orderStr, sex);
        System.out.println(users.size());
    }

    @Test
    public void selectIfOperTest() {
        // 获取对应mapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 执行查询语句并返回结果
        String email = "qq.com";
        Byte sex = null;
        List<User> users = userMapper.selectIfOper(email, sex);
        System.out.println(users.size());
    }

    @Test
    public void selectIfandWhereOperTest() {
        // 获取对应mapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 执行查询语句并返回结果
        String email = "qq.com";
        Byte sex = null;
        List<User> users = userMapper.selectIfandWhereOper(email, sex);
        System.out.println(users.size());
    }

    @Test
    public void updateIfOperTest() {
        // 获取对应mapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 执行查询语句并返回结果
        User user = new User();
        user.setId(3);
        user.setUserName("cindy");
        user.setRealName("王美丽");
        user.setEmail("xxoo@163.com");
        user.setMobile("18695988747");
        user.setNote("cindy's note");
        user.setSex((byte) 2);
        user.setPositionId(1);
        System.out.println(userMapper.updateIfOper(user));
    }

    @Test
    public void updateIfAndSetOperTest() {
        // 获取对应mapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 执行查询语句并返回结果
        User user = new User();
        user.setId(3);
        user.setUserName("cindy");
        user.setRealName("王美丽");
        user.setEmail("xxoo@163.com");
        user.setMobile("18695988747");
        user.setNote("cindy's note");
        user.setSex((byte) 2);
        user.setPositionId(1);
        System.out.println(userMapper.updateIfAndSetOper(user));
    }

    @Test
    public void insertIfOperTest() {
        // 获取对应mapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 执行查询语句并返回结果
        User user = new User();
        user.setUserName("mark");
        user.setRealName("毛毛");
        user.setEmail("xxoo@163.com");
        user.setMobile("18695988747");
        user.setNote("mark's note");
        user.setSex((byte) 1);
        user.setPositionId(1);
        System.out.println(userMapper.insertIfOper(user));
    }



}
