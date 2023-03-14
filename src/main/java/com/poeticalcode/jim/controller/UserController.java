package com.poeticalcode.jim.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poeticalcode.jim.entity.UserEntity;
import com.poeticalcode.jim.service.IUserService;

/**
 * 用户相关 api
 */
@RestController
@RequestMapping("/v1/user")
public class UserController {

  private IUserService userService;

  /**
   * 获取用户列表接口
   * 
   * @return
   */
  @GetMapping("/list")
  public Map<String, Object> userList() {
    List<UserEntity> list = userService.list();
    HashMap<String, Object> res = new HashMap<>();
    res.put("data", list);
    res.put("code", 1);
    return res;
  }

  @PostMapping("")
  public Map<String, Object> createUser(@RequestBody UserEntity user) {
    System.out.printf("userEntity = " + user);
    return null;
  }

  @Autowired
  public void setUserService(IUserService userService) {
    this.userService = userService;
  }

}
