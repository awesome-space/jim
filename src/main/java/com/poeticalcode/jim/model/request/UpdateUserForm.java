package com.poeticalcode.jim.model.request;


import lombok.Data;

/**
 * 更新用户表单
 *
 * @author poeticalcode
 */
@Data
public class UpdateUserForm {

  private String userName;

  private String password;
}
