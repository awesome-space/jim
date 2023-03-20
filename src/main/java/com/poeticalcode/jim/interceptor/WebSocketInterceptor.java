package com.poeticalcode.jim.interceptor;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import java.util.Map;


/**
 * @author poeticalcode
 */
@Component
public class WebSocketInterceptor implements HandshakeInterceptor {


  /**
   * 前置拦截一般用来注册用户信息，绑定 WebSocketSession
   *
   * @param request    the current request
   * @param response   the current response
   * @param wsHandler  the target WebSocket handler
   * @param attributes the attributes from the HTTP handshake to associate with the WebSocket
   *                   session; the provided attributes are copied, the original map is not used.
   * @return
   * @throws Exception
   */
  @Override
  public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response,
                                 WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {
    System.out.println("前置拦截~~");
    if (!(request instanceof ServletServerHttpRequest)) {
      return true;
    }
//            HttpServletRequest servletRequest = ((ServletServerHttpRequest) request).getServletRequest();
//            String userName = (String) servletRequest.getSession().getAttribute("userName");
    String userName = "Koishipyb";
    attributes.put("userName", userName);
    return true;
  }

  @Override
  public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response,
                             WebSocketHandler wsHandler, Exception exception) {
    System.out.println("后置拦截~~");
  }
}

