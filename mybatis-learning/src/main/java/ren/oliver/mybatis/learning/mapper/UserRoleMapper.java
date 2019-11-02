package ren.oliver.mybatis.learning.mapper;

import ren.oliver.mybatis.learning.pojo.UserRole;

public interface UserRoleMapper {

    int deleteByPrimaryKey(UserRole key);

    int insert(UserRole record);

    int insertSelective(UserRole record);

}
