package me.ryzeon.chatserver.chat.domain.services;

import me.ryzeon.chatserver.chat.domain.model.aggregates.ChatMessage;
import me.ryzeon.chatserver.chat.domain.model.queries.GetAllChatMessageByGroupId;

import java.util.List;

public interface ChatMessageQueryService {

    List<ChatMessage> handle(GetAllChatMessageByGroupId query);
}
