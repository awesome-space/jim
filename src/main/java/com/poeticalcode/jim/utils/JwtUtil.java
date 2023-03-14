package com.poeticalcode.jim.utils;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;

/**
 * jwt 工具类
 * 
 * @author poeticalcode
 */

public class JwtUtil {
  // 过期时间
  private final static Long expiration = 72000000L;
  // header
  private final static String tokenHeader = "Authorization";
  // 密钥
  private final static String secret = "secret";

  /**
   * 校验 token 是否正确
   *
   * @param token
   * @return 是否正确
   */
  public static boolean verify(String token, String userId) throws Exception {
    try {
      Algorithm algorithm = Algorithm.HMAC256(secret);
      JWTVerifier verifier = JWT.require(algorithm)
          .withClaim("userId", userId)
          .build();
      verifier.verify(token);
      return true;
    } catch (TokenExpiredException e) {
      throw new Exception("登录过期，请重新登录");
    } catch (Exception e) {
      throw e;
    }
  }

  /**
   * 从 Token 中获取 UserId
   *
   * @return token中包含的用户名
   */
  public static String getUserId(String token) {
    try {
      DecodedJWT jwt = JWT.decode(token);
      return jwt.getClaim("userId").asString();
    } catch (JWTDecodeException e) {
      throw new JWTDecodeException(e.getMessage());
    }
  }

  /**
   * 对用户 ID 进行签名获取 Token
   * 
   * @return
   */
  public static String sign(String userId) throws Exception {

    Algorithm algorithm = Algorithm.HMAC256(secret);
    // 设置过期时间
    Date expirDate = new Date(System.currentTimeMillis() + expiration * 1000);
    try {
      return JWT.create()
          .withClaim("userId", userId) // 对 userId 进行签名
          .withExpiresAt(expirDate) // 过期时间
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
    String requestHeader = request.getHeader(tokenHeader);
    String token = null;
    if (requestHeader != null && requestHeader.startsWith("Bearer ")) {
      token = requestHeader.substring(7);
    }
    return token;
  }

}
