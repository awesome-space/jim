package com.poeticalcode.jim.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.poeticalcode.jim.interceptor.JwtTokenInterceptor;

/**
 * 拦截器配置
 *
 * @author poeticalcode
 */
@Configuration
public class InterceptorConfiguration implements WebMvcConfigurer {

  private final JwtTokenInterceptor jwtTokenInterceptor;

  public InterceptorConfiguration(JwtTokenInterceptor jwtTokenInterceptor) {
    this.jwtTokenInterceptor = jwtTokenInterceptor;
  }

  /**
   * 注册 JwtToken 拦截器
   */
  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    // 排除登录接口
    registry.addInterceptor(jwtTokenInterceptor)
        .addPathPatterns("/**")
        .excludePathPatterns("/api/v1/user/login", "/api/v1/user/register")
        .excludePathPatterns("/v1/user/login");

  }

}
