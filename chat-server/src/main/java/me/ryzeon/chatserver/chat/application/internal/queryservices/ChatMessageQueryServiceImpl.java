package me.ryzeon.chatserver.chat.application.internal.queryservices;

import me.ryzeon.chatserver.chat.domain.model.aggregates.ChatMessage;
import me.ryzeon.chatserver.chat.domain.model.queries.GetAllChatMessageByGroupId;
import me.ryzeon.chatserver.chat.domain.services.ChatMessageQueryService;
import me.ryzeon.chatserver.chat.infrastructure.persistence.mongodb.ChatMessageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatMessageQueryServiceImpl implements ChatMessageQueryService {

    private final ChatMessageRepository chatMessageRepository;

    public ChatMessageQueryServiceImpl(ChatMessageRepository chatMessageRepository) {
        this.chatMessageRepository = chatMessageRepository;
    }

    @Override
    public List<ChatMessage> handle(GetAllChatMessageByGroupId query) {
        return List.of();
    }
}
