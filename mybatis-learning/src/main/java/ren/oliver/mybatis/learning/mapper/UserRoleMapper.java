package ren.oliver.mybatis.learning.mapper;

import ren.oliver.mybatis.learning.pojo.UserRoleKey;

public interface UserRoleMapper {

    int deleteByPrimaryKey(UserRoleKey key);

    int insert(UserRoleKey record);

    int insertSelective(UserRoleKey record);

}
