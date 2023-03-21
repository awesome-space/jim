package com.poeticalcode.jim.model.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.sql.Date;

/**
 * @author poeticalcode
 */
@Data
public class MessageEntity {


  /**
   * 主键
   */
  @TableId(type = IdType.ASSIGN_ID)
  private String id;

  /**
   * 消息内容
   */
  private String content;


  /**
   * 消息类型
   */
  private String type;


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
