package com.poeticalcode.jim.model.request;

import lombok.Data;

/**
 * 登录表单
 */
@Data
public class LoginForm {
  private String userName;
  private String password;
}
