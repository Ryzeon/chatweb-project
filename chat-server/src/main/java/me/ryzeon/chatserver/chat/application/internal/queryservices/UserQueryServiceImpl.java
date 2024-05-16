package me.ryzeon.chatserver.chat.application.internal.queryservices;

import me.ryzeon.chatserver.chat.domain.model.aggregates.User;
import me.ryzeon.chatserver.chat.domain.model.queries.GetAllOnlineUserByChatGroupId;
import me.ryzeon.chatserver.chat.domain.model.queries.GetAllUsersByChatGroupId;
import me.ryzeon.chatserver.chat.domain.services.UserQueryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserQueryServiceImpl implements UserQueryService {
    @Override
    public List<User> handle(GetAllUsersByChatGroupId query) {
        return List.of();
    }

    @Override
    public List<User> handle(GetAllOnlineUserByChatGroupId query) {
        return List.of();
    }
}
