package com.poeticalcode.jim.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.poeticalcode.jim.config.JwtTokenConfig;
import com.poeticalcode.jim.utils.JwtUtil;

import lombok.extern.slf4j.Slf4j;

/**
 * JwtToken 拦截器
 * 
 * @author poeticalcode
 */
@Slf4j
@Component
public class JwtTokenInterceptor implements HandlerInterceptor {

  private JwtTokenConfig jwtTokenConfig;

  public JwtTokenInterceptor(JwtTokenConfig jwtTokenConfig) {
    this.jwtTokenConfig = jwtTokenConfig;
  }

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    // 获取 Token
    log.info("jwtTokenConfig = {}", jwtTokenConfig);
    // String token = JwtUtil.getToken(request);
    // if (JwtUtil.verify(token, "userId")) {
    //   log.info("verify failed ");
    //   return true;
    // }
    // log.info("verify pass ");
    // 校验 Token
    return true;
  }




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
