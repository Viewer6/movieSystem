package com.viewer.moviesystem.domain.vo;

import lombok.Data;

@Data
public class ChatMessageVO {
    private String type; // 消息类型：system-系统消息，chat-聊天消息
    private String username; // 发送者
    private String receiver; // 接收者（为空表示群发）
    private String content; // 消息内容
    private String time; // 发送时间
} 