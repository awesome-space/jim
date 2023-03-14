package com.poeticalcode.jim.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.poeticalcode.jim.model.entity.UserEntity;
import com.poeticalcode.jim.model.request.LoginForm;

public interface IUserService extends IService<UserEntity>{
  /**
   * 根据用户名和密码查找用户
   */
  UserEntity findUserByUserNameAndPassword(LoginForm forn);
  


}
