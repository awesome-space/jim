package com.poeticalcode.jim.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.poeticalcode.jim.mapper.UserMapper;
import com.poeticalcode.jim.model.entity.UserEntity;
import com.poeticalcode.jim.model.request.LoginForm;
import com.poeticalcode.jim.service.IUserService;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements IUserService {

  @Override
  public UserEntity findUserByUserNameAndPassword(LoginForm form) {
    QueryWrapper<UserEntity> wrapper = new QueryWrapper<>();
    wrapper.eq("user_name", form.getUserName());
    wrapper.eq("password", form.getPassword());
    return baseMapper.selectOne(wrapper);
  }

}
