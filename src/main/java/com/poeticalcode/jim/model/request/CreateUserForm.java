package com.poeticalcode.jim.model.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import com.poeticalcode.jim.model.entity.UserEntity;

import lombok.Data;

/**
 * 创建用户表单
 */
@Data
public class CreateUserForm {

  /**
   * 用户名
   */
  @NotBlank(message = "名字为必填项")
  private String userName;
  /**
   * 手机号
   */
  private String phone;
  /**
   * 密码
   */
  @Length(min = 6, max = 16, message = "密码长度为 6 - 16 位")
  private String password;

  /**
   * 邮件
   */
  @Email(message = "请填写正确的邮箱地址")
  private String email;

  /**
   * 转成一个 UserEntity 对象
   */
  public UserEntity toUserEntity() {
    return UserEntity.builder().userName(userName)
        .phone(phone).email(email)
        .password(password).build();
  }

}
