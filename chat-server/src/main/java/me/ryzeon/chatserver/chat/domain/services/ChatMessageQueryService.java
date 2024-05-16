package me.ryzeon.chatserver.chat.domain.services;

import me.ryzeon.chatserver.chat.domain.model.aggregates.ChatMessage;
import me.ryzeon.chatserver.chat.domain.model.queries.GetAllChatMessageByGroupId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ChatMessageQueryService {

    Page<ChatMessage> handle(GetAllChatMessageByGroupId query, Pageable pageable);
}
