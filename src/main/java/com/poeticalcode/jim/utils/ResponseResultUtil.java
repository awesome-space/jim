package com.poeticalcode.jim.utils;

import com.poeticalcode.jim.model.reponse.ResponseResult;

/**
 * 响应结果工具类
 * 
 * @author poeticalcode
 */
public class ResponseResultUtil {

  /**
   * 生成 成功结果
   * 
   * @param message 响应信息
   * @return
   */
  public static ResponseResult GenSuccessResult(String message) {
    return ResponseResult.builder().code(1).message(message).build();
  }

  /**
   * 生成 成功结果
   * 
   * @param o
   * @return
   */
  public static ResponseResult GenSuccessResult(Object o) {
    return ResponseResult.builder().code(1).message("success").data(o).build();
  }

  /**
   * 生成 成功结果
   * 
   * @param o       响应数据
   * @param message 响应信息
   * @return
   */
  public static ResponseResult GenSuccessResult(Object o, String message) {
    return ResponseResult.builder().code(1).message("success").data(o).build();
  }

  /**
   * 生成 失败结果
   * 
   * @param o
   * @return
   */
  public static ResponseResult GenFailureResult(String message) {
    return ResponseResult.builder().code(0).message(message).build();
  }

}
