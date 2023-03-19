package com.poeticalcode.jim.controller;


import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

/**
 * web socket
 *
 * @author poeticalcode
 */

public class WebSocketController implements WebSocketHandler {


  @Override
  public void afterConnectionEstablished(WebSocketSession session) throws Exception {
    System.out.println("WebSocket连接已建立");
  }

  @Override
  public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
    System.out.println("收到WebSocket消息：" + message.getPayload());

    session.sendMessage(message);
  }

  @Override
  public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
    System.out.println("WebSocket传输错误：" + exception.getMessage());
  }

  @Override
  public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
    System.out.println("WebSocket连接已关闭，关闭状态为：" + closeStatus);
  }

  @Override
  public boolean supportsPartialMessages() {
    return false;
  }


}