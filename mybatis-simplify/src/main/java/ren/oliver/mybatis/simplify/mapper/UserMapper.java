package ren.oliver.mybatis.simplify.mapper;

import ren.oliver.mybatis.simplify.entity.User;

import java.util.List;

public interface UserMapper {

    User selectByPrimaryKey(Integer id);
    
    List<User> selectAll();

}