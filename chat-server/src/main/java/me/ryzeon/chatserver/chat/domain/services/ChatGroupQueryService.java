package me.ryzeon.chatserver.chat.domain.services;

import me.ryzeon.chatserver.chat.domain.model.aggregates.ChatGroup;
import me.ryzeon.chatserver.chat.domain.model.queries.GetAllChatGroupById;

import java.util.List;

public interface ChatGroupQueryService {

    List<ChatGroup> handle(GetAllChatGroupById query);
}
