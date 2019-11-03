package ren.oliver.mybatis.spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ren.oliver.mybatis.spring.entity.TUser;
import ren.oliver.mybatis.spring.mapper.TUserMapper;
import ren.oliver.mybatis.spring.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    TUserMapper tUserMapper;

    @Override
    public TUser getUserById(Integer id) {
        return tUserMapper.selectByPrimaryKey(id);
    }

}
