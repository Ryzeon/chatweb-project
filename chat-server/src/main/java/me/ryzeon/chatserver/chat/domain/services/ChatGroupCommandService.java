package me.ryzeon.chatserver.chat.domain.services;

import me.ryzeon.chatserver.chat.domain.model.aggregates.ChatGroup;
import me.ryzeon.chatserver.chat.domain.model.commands.CreateChatGroupCommand;

import java.util.Optional;

public interface ChatGroupCommandService {

    Optional<ChatGroup> handle(CreateChatGroupCommand command);
}
