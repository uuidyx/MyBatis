package ren.oliver.mybatis.learning.mapper;

import ren.oliver.mybatis.learning.pojo.HealthReportMale;

import java.util.List;

public interface HealthReportMaleMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(HealthReportMale record);

    int insertSelective(HealthReportMale record);

    HealthReportMale selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HealthReportMale record);

    int updateByPrimaryKey(HealthReportMale record);

    List<HealthReportMale> selectByUserId(Integer userId);

}
