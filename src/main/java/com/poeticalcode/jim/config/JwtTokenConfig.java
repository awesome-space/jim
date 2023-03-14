package com.poeticalcode.jim.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@ConfigurationProperties(prefix = "jwttoken")
public class JwtTokenConfig {
  private String headername;
  private Long expiration;
  private String secret;
}
