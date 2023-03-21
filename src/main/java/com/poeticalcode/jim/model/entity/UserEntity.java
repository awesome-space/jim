package com.poeticalcode.jim.model.entity;

import java.sql.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Builder;
import lombok.Data;

/**
 * 用户实体类
 *
 * @author poeticalcode
 */
@Data
@TableName("im_user")
@Builder
public class UserEntity {

  /**
   * 用户 ID
   */
  @TableId(type = IdType.ASSIGN_ID)
  private String id;
  /**
   * 用户名
   */
  private String userName;
  /**
   * 密码
   */
  private String password;
  /**
   * 头像
   */
  private String avatar;
  /**
   * 性别
   */
  private String gender;
  /**
   * 手机号
   */
  private String phone;
  /**
   * 邮箱
   */
  private String email;
  /**
   * 在线状态
   */
  private String onlineState;
  /**
   * 登录设备
   */
  private String deviceInfo;
  /**
   * 登录时间
   */
  private Date loginTime;
  /**
   * 心跳时间
   */
  private Date heartBeatTime;
  /**
   * 退出时间
   */
  private Date loginOutTime;
  /**
   * 创建时间
   */
  private Date createdAt;
  /**
   * 更新时间
   */
  private Date updatedAt;
  /**
   * 删除时间
   */
  private Date deletedAt;

}
