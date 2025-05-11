package com.viewer.moviesystem.websocket;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.viewer.moviesystem.domain.vo.ChatMessageVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.socket.*;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class ChatWebSocketHandler extends TextWebSocketHandler {
    // 用户会话映射，key是用户名，value是WebSocket会话
    private static final Map<String, WebSocketSession> userSessions = new ConcurrentHashMap<>();
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Override
    public void afterConnectionEstablished(WebSocketSession session) {
        String username = getUsernameFromSession(session);
        if (username != null) {
            userSessions.put(username, session);
            // 发送系统消息通知用户上线
            sendSystemMessage(username + " 已上线", username);
            // 发送更新后的在线用户列表
            sendOnlineUsers();
            log.info("用户 {} 已连接，当前在线人数：{}", username, userSessions.size());
        }
    }

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String username = getUsernameFromSession(session);
        if (username == null) return;

        // 解析消息
        ChatMessageVO chatMessage = objectMapper.readValue(message.getPayload(), ChatMessageVO.class);
        chatMessage.setUsername(username);
        chatMessage.setTime(LocalDateTime.now().format(formatter));
        chatMessage.setType("chat");

        // 发送消息
        if (chatMessage.getReceiver() != null && !chatMessage.getReceiver().isEmpty()) {
            // 私聊消息
            sendPrivateMessage(chatMessage);
        } else {
            // 群发消息
            broadcastMessage(chatMessage);
        }
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {
        String username = getUsernameFromSession(session);
        if (username != null) {
            userSessions.remove(username);
            // 发送系统消息通知用户下线
            sendSystemMessage(username + " 已下线", username);
            // 发送更新后的在线用户列表
            sendOnlineUsers();
            log.info("用户 {} 已断开连接，当前在线人数：{}", username, userSessions.size());
        }
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) {
        log.error("WebSocket传输错误", exception);
        String username = getUsernameFromSession(session);
        if (username != null) {
            userSessions.remove(username);
        }
    }

    // 从会话中获取用户名
    private String getUsernameFromSession(WebSocketSession session) {
        String query = session.getUri().getQuery();
        if (query != null) {
            for (String param : query.split("&")) {
                String[] pair = param.split("=", 2);
                if (pair.length == 2 && pair[0].equals("username")) {
                    try {
                        return java.net.URLDecoder.decode(pair[1], "UTF-8");
                    } catch (Exception e) {
                        return pair[1];
                    }
                }
            }
        }
        return null;
    }

    // 发送系统消息
    private void sendSystemMessage(String content, String username) {
        ChatMessageVO systemMessage = new ChatMessageVO();
        systemMessage.setType("system");
        systemMessage.setContent(content);
        systemMessage.setUsername(username);
        systemMessage.setTime(LocalDateTime.now().format(formatter));
        broadcastMessage(systemMessage);
    }

    // 发送私聊消息
    private void sendPrivateMessage(ChatMessageVO message) {
        try {
            String receiver = message.getReceiver();
            WebSocketSession receiverSession = userSessions.get(receiver);
            if (receiverSession != null && receiverSession.isOpen()) {
                String messageJson = objectMapper.writeValueAsString(message);
                receiverSession.sendMessage(new TextMessage(messageJson));
                // 同时发送给发送者
                WebSocketSession senderSession = userSessions.get(message.getUsername());
                if (senderSession != null && senderSession.isOpen()) {
                    senderSession.sendMessage(new TextMessage(messageJson));
                }
            } else {
                // 接收者不在线，发送系统消息通知发送者
                ChatMessageVO offlineMessage = new ChatMessageVO();
                offlineMessage.setType("system");
                offlineMessage.setContent("用户 " + receiver + " 不在线");
                offlineMessage.setTime(LocalDateTime.now().format(formatter));
                WebSocketSession senderSession = userSessions.get(message.getUsername());
                if (senderSession != null && senderSession.isOpen()) {
                    senderSession.sendMessage(new TextMessage(objectMapper.writeValueAsString(offlineMessage)));
                }
            }
        } catch (IOException e) {
            log.error("发送私聊消息失败", e);
        }
    }

    // 广播消息
    private void broadcastMessage(ChatMessageVO message) {
        try {
            String messageJson = objectMapper.writeValueAsString(message);
            for (WebSocketSession session : userSessions.values()) {
                if (session.isOpen()) {
                    session.sendMessage(new TextMessage(messageJson));
                }
            }
        } catch (IOException e) {
            log.error("广播消息失败", e);
        }
    }

    // 发送在线用户列表
    private void sendOnlineUsers() {
        // 实现发送在线用户列表的逻辑
    }
} 