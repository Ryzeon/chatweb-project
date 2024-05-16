package me.ryzeon.chatserver.chat.domain.services;

import me.ryzeon.chatserver.chat.domain.model.aggregates.User;
import me.ryzeon.chatserver.chat.domain.model.commands.CreateUserCommand;
import me.ryzeon.chatserver.chat.domain.model.commands.JoinUserGroupCommand;
import me.ryzeon.chatserver.chat.domain.model.commands.LeaveUserGroupCommand;

import java.util.Optional;

public interface UserCommandService {

    Optional<User> handle(CreateUserCommand command);

    void handle(JoinUserGroupCommand command);

    void handle(LeaveUserGroupCommand command);
}
