package com.poeticalcode.jim.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.poeticalcode.jim.utils.JwtUtil;

import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

/**
 * JwtToken 拦截器
 *
 * @author poeticalcode
 */
@Slf4j
@Component
public class JwtTokenInterceptor implements HandlerInterceptor {

  /**
   * 处理之前，在这里可以做 token 验证
   * @param request current HTTP request 请求
   * @param response current HTTP response 相应
   * @param handler chosen handler to execute, for type and/or instance evaluation 
   * @return
   * @throws Exception
   */
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    String token = JwtUtil.getToken(request);
    // 打印 token
    log.info("token = {}", token);
    if (Objects.nonNull(token) && JwtUtil.verify(token)) {
      log.info("verify pass ");
      return true;
    }
    // 打印失败
    log.info("verify failed ");
    return false;
  }

  /**
   * 
   */
  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
      @Nullable ModelAndView modelAndView) throws Exception {
    HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
  }

  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
      @Nullable Exception ex) throws Exception {
    HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
  }

}
