package com.poeticalcode.jim.entity;

import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 用户实体类
 * 
 * @author poeticalcode
 */
@TableName("im_user")
public class UserEntity {
  // 用户 ID
  private Long id;


  public void setId(Long id) {
    this.id = id;
  }

  public Long getId() {
    return id;
  }

}
