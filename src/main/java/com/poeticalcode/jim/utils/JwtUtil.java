package com.poeticalcode.jim.utils;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.poeticalcode.jim.config.JwtTokenConfig;

import lombok.extern.slf4j.Slf4j;

/**
 * jwt 工具类
 * 
 * @author poeticalcode
 */

@Slf4j
@Component
public class JwtUtil {
  private static JwtTokenConfig jwtTokenConfig;
  private static Algorithm algorithm;

  /**
   * 校验 token 是否正确
   *
   * @param token
   * @return 是否正确
   */
  public static boolean verify(String token) throws Exception {
    try {
      JWTVerifier verifier = JWT.require(algorithm).build();
      verifier.verify(token);
      return true;
    } catch (TokenExpiredException e) {
      throw new Exception("登录过期，请重新登录");
    } catch (Exception e) {
      throw e;
    }
  }

  /**
   * 从 Token 中获取 UId
   *
   * @return token中包含的用户名
   */
  public static String getUId(String token) {
    try {
      DecodedJWT jwt = JWT.decode(token);
      return jwt.getClaim("uid").asString();
    } catch (JWTDecodeException e) {
      throw new JWTDecodeException(e.getMessage());
    }
  }

  /**
   * 对用户 ID 进行签名获取 Token
   * 
   * @return
   */
  public static String sign(String uid) throws Exception {
    try {
      long curr = System.currentTimeMillis();
      log.info("ExpiresAt {}", new Date(curr + jwtTokenConfig.getExpiration() * 1000));
      return JWT.create()
          .withClaim("uid", uid)
          .withIssuedAt(new Date(curr))
          .withExpiresAt(new Date(curr + jwtTokenConfig.getExpiration() * 1000))
          .sign(algorithm);
    } catch (Exception e) {
      throw new Exception("sign error ");
    }
  }

  /**
   * 获取请求token
   *
   * @param request HttpServletRequest
   * @return token
   */
  public static String getToken(HttpServletRequest request) {
    return request.getHeader(jwtTokenConfig.getHeadername());
  }

  /**
   * 获取 Token 保存的名字
   * 
   * @return
   */
  public static String headerName() {
    return jwtTokenConfig.getHeadername();
  }

  @Autowired
  public void setJwtTokenConfig(JwtTokenConfig jwtTokenConfig) {
    JwtUtil.jwtTokenConfig = jwtTokenConfig;
    JwtUtil.algorithm = Algorithm.HMAC256(jwtTokenConfig.getSecret());
  }

}
