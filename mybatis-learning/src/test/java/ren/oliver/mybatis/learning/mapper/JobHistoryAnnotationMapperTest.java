package ren.oliver.mybatis.learning.mapper;

import ren.oliver.mybatis.learning.pojo.JobHistory;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class JobHistoryAnnotationMapperTest {

    @Test
    public void selectByUserIdTest() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 读取MyBatis配置文件创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        inputStream.close();
        // 获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 获取对应mapper
        JobHistoryAnnotationMapper jobHistoryAnnotationMapper =
                sqlSession.getMapper(JobHistoryAnnotationMapper.class);
        // 执行查询语句并返回结果
        List<JobHistory> jobHistories = jobHistoryAnnotationMapper.selectByUserId(1);
        System.out.println(jobHistories.toString());
    }

    @Test
    public void selectAllTest() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 读取MyBatis配置文件创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        inputStream.close();
        // 获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 获取对应mapper
        JobHistoryAnnotationMapper jobHistoryAnnotationMapper =
                sqlSession.getMapper(JobHistoryAnnotationMapper.class);
        // 执行查询语句并返回结果
        List<JobHistory> jobHistories = jobHistoryAnnotationMapper.selectAll();
        System.out.println(jobHistories.toString());
    }

    @Test
    public void insertTest() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 读取MyBatis配置文件创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        inputStream.close();
        // 获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 获取对应mapper
        JobHistoryAnnotationMapper jobHistoryAnnotationMapper =
                sqlSession.getMapper(JobHistoryAnnotationMapper.class);
        // 执行语句
        JobHistory jobHistory = new JobHistory();
        jobHistory.setUserId(1);
        jobHistory.setCompName("阿里云");
        jobHistory.setTitle("测试实习生");
        jobHistory.setYears(1);
        jobHistoryAnnotationMapper.insert(jobHistory);
    }

}
