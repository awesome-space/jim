package com.poeticalcode.jim.model.entity;

import java.sql.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

/**
 * 用户实体类
 * 
 * @author poeticalcode
 */
@Data
@TableName("im_user")
public class UserEntity {

  // 用户 ID
  @TableId(type = IdType.ASSIGN_ID)
  private Long id;
  private String userName; // 用户名
  private String password; // 密码
  private String avatar; // 头像
  private String gender; // 性别
  private String phone; // 手机号
  private String email; // 邮箱
  private String onlineState; // 在线状态
  private String deviceInfo; // 登录设备
  private Date loginTime; // 登录时间
  private Date heartBeatTime; // 心跳时间
  private Date loginOutTime; // 退出时间
  private Date createdAt; // 创建时间
  private Date updatedAt; // 更新时间
  private Date deletedAt; // 删除时间
  
}
