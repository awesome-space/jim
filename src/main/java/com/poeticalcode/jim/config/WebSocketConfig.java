package com.poeticalcode.jim.config;


import com.poeticalcode.jim.controller.WebSocketController;
import com.poeticalcode.jim.interceptor.WebSocketInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.HandshakeInterceptor;

import java.util.Map;

/**
 * @author poeticalcode
 */
@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

  private final WebSocketInterceptor webSocketInterceptor;

  private final WebSocketController webSocketController;


  public WebSocketConfig(WebSocketInterceptor webSocketInterceptor, WebSocketController webSocketController) {
    this.webSocketInterceptor = webSocketInterceptor;
    this.webSocketController = webSocketController;
  }


  @Override
  public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
    registry.addHandler(webSocketController, "/chat")
            .setAllowedOrigins("*")
            .addInterceptors(webSocketInterceptor);
  }


}