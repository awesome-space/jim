package com.poeticalcode.jim.model.request;

import lombok.Data;

/**
 * 修改密码表单
 * 
 * @author poeticalcode
 */

@Data
public class ModifyPasswordForm {
  private String password;
  private String oldPassword;
}
