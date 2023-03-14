package com.poeticalcode.jim.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.poeticalcode.jim.entity.UserEntity;
import com.poeticalcode.jim.mapper.UserMapper;
import com.poeticalcode.jim.service.IUserService;


@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,UserEntity> implements IUserService {
  
}
