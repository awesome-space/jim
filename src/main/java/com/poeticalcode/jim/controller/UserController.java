package com.poeticalcode.jim.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poeticalcode.jim.model.entity.UserEntity;
import com.poeticalcode.jim.model.reponse.ResponseResult;
import com.poeticalcode.jim.model.request.CreateUserForm;
import com.poeticalcode.jim.model.request.LoginForm;
import com.poeticalcode.jim.model.request.ModifyPasswordForm;
import com.poeticalcode.jim.service.IUserService;
import com.poeticalcode.jim.utils.JwtUtil;
import com.poeticalcode.jim.utils.ResponseResultUtil;

import lombok.extern.slf4j.Slf4j;

/**
 * 用户相关 api
 * 
 * @author poeticalcode
 */
@Slf4j
@RestController
@RequestMapping("/v1/user")
public class UserController {

  private IUserService userService;

  /**
   * 获取用户列表接口
   * 
   * @return ResponseResult
   */
  @GetMapping("/list")
  @Validated
  public ResponseResult userList() {
    List<UserEntity> list = userService.list();
    HashMap<String, Object> res = new HashMap<>();
    res.put("data", list);
    res.put("code", 1);
    return ResponseResultUtil.GenSuccessResult(res, "添加成功");
  }

  /**
   * 创建用户接口
   */
  @PostMapping("")
  public ResponseResult createUser(@Validated @RequestBody CreateUserForm form) {
    log.info("CreateUserForm = {}", form);
    UserEntity u = form.toUserEntity();
    boolean res = userService.save(u);
    if (res) {
      return ResponseResultUtil.GenSuccessResult(u, "添加成功");
    }
    return ResponseResultUtil.GenFailureResult("添加失败");
  }

  /**
   * 删除用户接口
   */
  @DeleteMapping("/{id}")
  public ResponseResult deleteUser(@PathVariable("id") Long id) {
    // 调用删除接口
    boolean res = userService.removeById(id);
    if (res) {
      return ResponseResultUtil.GenSuccessResult("删除成功");
    }
    return ResponseResultUtil.GenFailureResult("删除失败");
  }

  /**
   * 用户登录接口
   */
  @PostMapping("/login")
  public ResponseResult login(@RequestBody LoginForm form) throws Exception {
    log.info("loginForm = {}", form);
    UserEntity user = userService.findUserByUserNameAndPassword(form);
    if (Objects.nonNull(user)) {
      Map<String, String> res = new HashMap<String, String>();
      res.put("token", JwtUtil.sign(user.getId()));
      res.put("headerName", JwtUtil.headerName());
      return ResponseResultUtil.GenSuccessResult(res, "登录成功");
    }
    return ResponseResultUtil.GenFailureResult("登录失败");
  }

  /**
   * 修改密码
   */
  @PutMapping("/password")
  public ResponseResult modifyPassword(@RequestBody ModifyPasswordForm form) {
    log.info("ModifyPasswordForm === {}", form);
    return ResponseResultUtil.GenFailureResult("修改成功");
  }

  @Autowired
  public void setUserService(IUserService userService) {
    this.userService = userService;
  }

}
