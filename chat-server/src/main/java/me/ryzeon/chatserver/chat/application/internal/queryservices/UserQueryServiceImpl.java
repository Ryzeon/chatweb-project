package me.ryzeon.chatserver.chat.application.internal.queryservices;

import me.ryzeon.chatserver.chat.domain.model.aggregates.User;
import me.ryzeon.chatserver.chat.domain.model.aggregates.UserStatus;
import me.ryzeon.chatserver.chat.domain.model.queries.GetAllOnlineUserByChatGroupId;
import me.ryzeon.chatserver.chat.domain.model.queries.GetAllUsersByChatGroupId;
import me.ryzeon.chatserver.chat.domain.services.UserQueryService;
import me.ryzeon.chatserver.chat.infrastructure.persistence.mongodb.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class UserQueryServiceImpl implements UserQueryService {

    private final UserRepository userRepository;

    public UserQueryServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> handle(GetAllUsersByChatGroupId query) {
        return userRepository.getAllByChatGroupsContains(query.groupId());
    }

    @Override
    public List<User> handle(GetAllOnlineUserByChatGroupId query) {
        return userRepository.getAllByChatGroupsContainsAndStatusIs(query.groupId(), UserStatus.ONLINE);
    }
}
