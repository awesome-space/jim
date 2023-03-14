package com.poeticalcode.jim.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 全局跨域配置：无需每个接口增加 @CrossOrigin
 * https://docs.spring.io/spring-boot/docs/2.7.9/reference/html/web.html#web.servlet.spring-mvc.cors
 * 
 * @author poeticalcode
 */
@Configuration
public class GlobalCrosConfiguration {
  @Bean
  public WebMvcConfigurer corsConfigurer() {
    return new WebMvcConfigurer() {
      @Override
      public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**");
      }
    };
  }
}
