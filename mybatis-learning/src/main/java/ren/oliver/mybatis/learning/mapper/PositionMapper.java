package ren.oliver.mybatis.learning.mapper;

import ren.oliver.mybatis.learning.pojo.Position;

public interface PositionMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Position record);

    int insertSelective(Position record);

    Position selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Position record);

    int updateByPrimaryKey(Position record);

}
