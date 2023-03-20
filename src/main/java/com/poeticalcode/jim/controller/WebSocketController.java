package com.poeticalcode.jim.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * web socket
 *
 * @author poeticalcode
 */

@Slf4j
@Component
public class WebSocketController implements WebSocketHandler {

  private Set<WebSocketSession> sessions = Collections.synchronizedSet(new HashSet<>());

  @Override
  public void afterConnectionEstablished(WebSocketSession session) throws Exception {
    sessions.add(session);
    log.info("WebSocket连接已建立");
  }

  @Override
  public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
    log.info("收到WebSocket消息: {}", message.getPayload());
    session.sendMessage(message);
  }

  @Override
  public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
    log.info("WebSocket传输错误: {}", exception.getMessage());
  }

  @Override
  public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
    System.out.println("WebSocket连接已关闭，关闭状态为：" + closeStatus);
    log.info("WebSocket连接已关闭,关闭状态为: {}", closeStatus);
  }


  @Override
  public boolean supportsPartialMessages() {
    return false;
  }


}