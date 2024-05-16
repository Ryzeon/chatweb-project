package me.ryzeon.chatserver.chat.domain.services;

import me.ryzeon.chatserver.chat.domain.model.aggregates.User;
import me.ryzeon.chatserver.chat.domain.model.queries.GetAllOnlineUserByChatGroupId;
import me.ryzeon.chatserver.chat.domain.model.queries.GetAllUsersByChatGroupId;

import java.util.List;

public interface UserQueryService {

    List<User> handle(GetAllUsersByChatGroupId query);
    List<User> handle(GetAllOnlineUserByChatGroupId query);
}
