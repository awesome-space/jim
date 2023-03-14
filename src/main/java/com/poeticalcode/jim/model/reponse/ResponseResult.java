package com.poeticalcode.jim.model.reponse;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseResult {
  /**
   * 响应码
   */
  private int code;
  /**
   * 响应数据
   */
  private Object data;

  /**
   * 响应消息
   */
  private String message;
}
