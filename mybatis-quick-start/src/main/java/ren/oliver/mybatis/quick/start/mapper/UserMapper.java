package ren.oliver.mybatis.quick.start.mapper;

import ren.oliver.mybatis.quick.start.pojo.User;

public interface UserMapper {

    User selectByPrimaryKey(Integer id);

}
