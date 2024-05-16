package me.ryzeon.chatserver.chat.domain.services;

import me.ryzeon.chatserver.chat.domain.model.aggregates.ChatGroup;
import me.ryzeon.chatserver.chat.domain.model.queries.GetAllChatGroupByIds;

import java.util.List;

public interface ChatGroupQueryService {

    List<ChatGroup> handle(GetAllChatGroupByIds query);
}
