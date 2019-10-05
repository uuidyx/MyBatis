package ren.oliver.mybatis.learning.mapper;

import ren.oliver.mybatis.learning.pojo.JobHistory;

import java.util.List;

public interface JobHistoryMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(JobHistory record);

    int insertSelective(JobHistory record);

    JobHistory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(JobHistory record);

    int updateByPrimaryKey(JobHistory record);

    List<JobHistory> selectByUserId(int userId);

}
