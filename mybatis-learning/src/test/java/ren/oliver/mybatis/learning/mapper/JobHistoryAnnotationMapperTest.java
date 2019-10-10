package ren.oliver.mybatis.learning.mapper;

import ren.oliver.mybatis.learning.pojo.JobHistory;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class JobHistoryAnnotationMapperTest {

    SqlSessionFactory sqlSessionFactory;

    SqlSession sqlSession;

    @Before
    public void init() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 1.读取mybatis配置文件创SqlSessionFactory
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        inputStream.close();
        // 获取SqlSession
        sqlSession = sqlSessionFactory.openSession();
    }

    @Test
    public void selectByUserIdTest() {
        // 获取对应mapper
        JobHistoryAnnotationMapper jobHistoryAnnotationMapper =
                sqlSession.getMapper(JobHistoryAnnotationMapper.class);
        // 执行查询语句并返回结果
        List<JobHistory> jobHistories = jobHistoryAnnotationMapper.selectByUserId(1);
        System.out.println(jobHistories.toString());
    }

    @Test
    public void selectAllTest() {
        // 获取对应mapper
        JobHistoryAnnotationMapper jobHistoryAnnotationMapper =
                sqlSession.getMapper(JobHistoryAnnotationMapper.class);
        // 执行查询语句并返回结果
        List<JobHistory> jobHistories = jobHistoryAnnotationMapper.selectAll();
        System.out.println(jobHistories.toString());
    }

    @Test
    public void insertTest() {
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
