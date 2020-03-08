package ren.oliver.mybatis.simplify.mapper;

import ren.oliver.mybatis.simplify.entity.TUser;

import java.util.List;


public interface TUserMapper {
	


    TUser selectByPrimaryKey(Integer id);
    
    List<TUser> selectAll();

    
    
    
    
    
}