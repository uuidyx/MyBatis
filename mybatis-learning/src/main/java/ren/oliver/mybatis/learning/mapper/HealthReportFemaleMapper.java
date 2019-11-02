package ren.oliver.mybatis.learning.mapper;

import ren.oliver.mybatis.learning.pojo.HealthReportFemale;

import java.util.List;

public interface HealthReportFemaleMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(HealthReportFemale record);

    int insertSelective(HealthReportFemale record);

    HealthReportFemale selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HealthReportFemale record);

    int updateByPrimaryKey(HealthReportFemale record);

    List<HealthReportFemale> selectByUserId(Integer userId);

}
