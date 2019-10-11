package ren.oliver.mybatis.learning.mapper;

import org.apache.ibatis.session.ExecutorType;
import org.junit.Before;
import ren.oliver.mybatis.learning.pojo.EmailSexBean;
import ren.oliver.mybatis.learning.pojo.User;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.Arrays;
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
    public void selectIfOper1Test() {
        // 获取对应mapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 执行查询语句并返回结果
        String email = "qq.com";
        Byte sex = null;
        List<User> users = userMapper.selectIfOper1(email, sex);
        System.out.println(users.size());
    }

    @Test
    public void selectIfOper2Test() {
        // 获取对应mapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 执行查询语句并返回结果
        String email = "qq.com";
        Byte sex = null;
        List<User> users = userMapper.selectIfOper2(email, sex);
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
    public void updateIfOper1Test() {
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
        System.out.println(userMapper.updateIfOper1(user));
    }

    @Test
    public void updateIfOper2Test() {
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
        System.out.println(userMapper.updateIfOper2(user));
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

    @Test
    public void selectForeach4In() {
        // 获取对应mapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 执行查询语句并返回结果
        String[] names = new String[]{"lison", "james"};
        List<User> users = userMapper.selectForeach4In(names);
        System.out.println(users.size());
    }

    @Test
    public void insertForeach4BatchTest() {
        // 获取对应mapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 执行查询语句并返回结果
        User user1 = new User();
        user1.setUserName("king");
        user1.setRealName("李小京");
        user1.setEmail("li@qq.com");
        user1.setMobile("18754548787");
        user1.setNote("king's note");
        user1.setSex((byte)1);
        User user2 = new User();
        user2.setUserName("deer");
        user2.setRealName("陈大林");
        user2.setEmail("chen@qq.com");
        user2.setMobile("18723138787");
        user2.setNote("deer's note");
        user2.setSex((byte)1);
        System.out.println(userMapper.insertForeach4Batch(Arrays.asList(user1,user2)));
    }

    @Test
    public void batchExcutorTest() {
        // 获取sqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH, false);
        // 获取对应mapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user1 = new User();
        user1.setUserName("mark");
        user1.setRealName("毛毛");
        user1.setEmail("xxoo@163.com");
        user1.setMobile("18695988747");
        user1.setNote("mark's note");
        user1.setSex((byte) 1);
        user1.setPositionId(1);
        System.out.println(userMapper.insertSelective(user1));

        User user2 = new User();
        user2.setId(3);
        user2.setUserName("cindy");
        user2.setRealName("王美丽");
        user2.setEmail("xxoo@163.com");
        user2.setMobile("18695988747");
        user2.setNote("cindy's note");
        user2.setSex((byte) 2);
        user2.setPositionId(1);
        System.out.println(userMapper.updateIfOper1(user2));

        sqlSession.commit();
    }

}
