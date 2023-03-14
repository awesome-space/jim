package com.poeticalcode.jim.model.request;

import lombok.Data;

/**
 * 创建用户表单
 */
@Data
public class CreateUserForm {

  /**
   * 用户名
   */
  private String userName;
  /**
   * 手机号
   */
  private String phone;
  /**
   * 密码
   */
  private String password;

  /**
   * 邮件
   */
  private String email;

}
