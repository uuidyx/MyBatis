package ren.oliver.mybatis.learning.mapper;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.session.ExecutorType;
import org.junit.Before;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import ren.oliver.mybatis.learning.pojo.EmailSexBean;
import ren.oliver.mybatis.learning.pojo.User;

import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserMapperTest {

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
    public void deleteByPrimaryKeyTest() {
        // 获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 获取对应mapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 执行查询语句并返回结果
        userMapper.deleteByPrimaryKey(1);
    }

    @Test
    public void insert1Test() {
        // 获取sqlSession
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
    public void insert2Test() {
        // 获取sqlSession
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
    public void insertSelectiveTest() {
        // 获取sqlSession
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
    public void selectByPrimaryKeyTest() {
        // 获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 获取对应mapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 进行分页
        Page<User> startPage = PageHelper.startPage(1, 1);
        // 执行查询语句并返回结果
        User user = userMapper.selectByPrimaryKey(1);
        System.out.println(user.toString());
        System.out.println(startPage);
    }

    @Test
    public void updateByPrimaryKeySelectiveTest() {
        // 获取sqlSession
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
    public void updateByPrimaryKeyTest() {
        // 获取sqlSession
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
    public void selectByEmailAndSex1Test() {
        // 获取sqlSession
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
    public void selectByEmailAndSex2Test() {
        // 获取sqlSession
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
    public void selectByEmailAndSex3Test() {
        // 获取sqlSession
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

    @Test
    public void selectBySymbolTest() {
        // 获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
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
        // 获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
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
        // 获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
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
        // 获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
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
        // 获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
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
        System.out.println(userMapper.updateIfOper1(user));
    }

    @Test
    public void updateIfOper2Test() {
        // 获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
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
        System.out.println(userMapper.updateIfOper2(user));
    }

    @Test
    public void updateIfAndSetOperTest() {
        // 获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
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
        System.out.println(userMapper.updateIfAndSetOper(user));
    }

    @Test
    public void insertIfOperTest() {
        // 获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
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
        System.out.println(userMapper.insertIfOper(user));
    }

    @Test
    public void selectForeach4In() {
        // 获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 获取对应mapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 执行查询语句并返回结果
        String[] names = new String[]{"lison", "james"};
        List<User> users = userMapper.selectForeach4In(names);
        System.out.println(users.size());
    }

    @Test
    public void insertForeach4BatchTest() {
        // 获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
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
        System.out.println(userMapper.insertSelective(user1));

        User user2 = new User();
        user2.setId(3);
        user2.setUserName("cindy");
        user2.setRealName("王美丽");
        user2.setEmail("xxoo@163.com");
        user2.setMobile("18695988747");
        user2.setNote("cindy's note");
        user2.setSex((byte) 2);
        System.out.println(userMapper.updateIfOper1(user2));

        sqlSession.commit();
    }

    @Test
    public void selectChooseOperTest() {
        // 获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH, false);
        // 获取对应mapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 执行相关查询
        String email = "qq.com";
        Byte sex = 2;
        List<User> list = userMapper.selectChooseOper(email , sex);
        System.out.println(list.size());
    }

    @Test
    public void selectUserPosition1Test() {
        // 获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH, false);
        // 获取对应mapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 执行相关查询
        List<User> list = userMapper.selectUserPosition1();
        System.out.println(list.size());
    }

    @Test
    public void selectUserPosition2Test() {
        // 获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH, false);
        // 获取对应mapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 执行相关查询
        List<User> list = userMapper.selectUserPosition2();
        System.out.println(list.size());
    }

    @Test
    public void selectUserJobs1Test() {
        // 获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 获取对应mapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 执行查询语句并返回结果
        List<User> users = userMapper.selectUserJobs1();
        System.out.println(users.toString());
    }

    @Test
    public void selectUserJobs2Test() {
        // 获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 获取对应mapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 执行查询语句并返回结果
        List<User> users = userMapper.selectUserJobs2();
        System.out.println(users.toString());
    }

    @Test
    public void selectUserHealthReportTest() {
        // 获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 获取对应mapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 执行查询语句并返回结果
        List<User> users = userMapper.selectUserHealthReport();
        System.out.println(users.toString());
    }

    @Test
    public void selectUserRoleTest() {
        // 获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 获取对应mapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 执行查询语句并返回结果
        List<User> users = userMapper.selectUserRole();
        System.out.println(users.toString());
    }

    @Test
    public void level1CacheTest() {
        // 获取sqlSession
        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        // 获取对应mapper
        UserMapper userMapper1 = sqlSession1.getMapper(UserMapper.class);
        // 执行查询语句并返回结果
        String email = "qq.com";
        Byte sex = 1;
        List<User> list1 = userMapper1.selectByEmailAndSex2(email, sex);
        System.out.println(list1.size());

        // 增删改操作会清空一级缓存和二级缓存
		User userInsert = new User();
		userInsert.setUserName("test1");
		userInsert.setRealName("realname1");
		userInsert.setEmail("myemail1");
        userMapper1.insert1(userInsert);

        List<User> list2 = userMapper1.selectByEmailAndSex2(email, sex);
        System.out.println(list2.size());

        HashMap<String, Object> map = new HashMap<>();
        map.put("email", email);
        map.put("sex", sex);
        List<User> list3 = userMapper1.selectByEmailAndSex1(map);
        System.out.println(list3.size());

        // 一级缓存是SQLSession维度的，关闭SQLSession将失效
        sqlSession1.close();

        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        UserMapper userMapper2 = sqlSession2.getMapper(UserMapper.class);
        List<User> list4 = userMapper2.selectByEmailAndSex2(email, sex);
        System.out.println(list4.size());
        sqlSession2.close();
    }

    @Test
    public void level2CacheTest() {
        SqlSession sqlSession1 = sqlSessionFactory.openSession();

        UserMapper userMapper1 = sqlSession1.getMapper(UserMapper.class);
        String email = "qq.com";
        Byte sex = 1;
        List<User> list1 = userMapper1.selectByEmailAndSex2(email, sex);
        System.out.println(list1.size());

        List<User> list2 = userMapper1.selectByEmailAndSex2(email, sex);
        System.out.println(list2.size());

		User userInsert = new User();
		userInsert.setUserName("test1");
		userInsert.setRealName("realname1");
		userInsert.setEmail("myemail1");
		userMapper1.insert1(userInsert);

        List<User> list3 = userMapper1.selectByEmailAndSex2(email, sex);
        System.out.println(list3.size());
        sqlSession1.close();


        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        UserMapper userMapper2 = sqlSession2.getMapper(UserMapper.class);
        List<User> list4 = userMapper2.selectByEmailAndSex2(email, sex);
        System.out.println(list4.size());
        sqlSession2.close();

        SqlSession sqlSession3 = sqlSessionFactory.openSession();
        JobHistoryMapper userMapper3 = sqlSession3.getMapper(JobHistoryMapper.class);
        List<User> list5 = userMapper3.selectByEmailAndSex2(email, sex);
        System.out.println(list5.size());
        sqlSession3.close();
    }

    @Test
    public void selectUserByRoleIdTest() {
        // 获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 获取对应mapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 执行查询语句并返回结果
        Integer id = 1;
        List<User> users = userMapper.selectUserByRoleId(id);
        System.out.println(users.size());
    }

}
