package me.ryzeon.chatserver.chat.application.internal.queryservices;

import me.ryzeon.chatserver.chat.domain.model.aggregates.ChatGroup;
import me.ryzeon.chatserver.chat.domain.model.queries.GetAllChatGroupByIds;
import me.ryzeon.chatserver.chat.domain.services.ChatGroupQueryService;
import me.ryzeon.chatserver.chat.infrastructure.persistence.mongodb.ChatGroupRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatGroupQueryServiceImpl implements ChatGroupQueryService {

    private final ChatGroupRepository chatGroupRepository;

    public ChatGroupQueryServiceImpl(ChatGroupRepository chatGroupRepository) {
        this.chatGroupRepository = chatGroupRepository;
    }

    @Override
    public List<ChatGroup> handle(GetAllChatGroupByIds query) {
        return chatGroupRepository.findAllById(query.ids());
    }
}
