package me.ryzeon.chatserver.chat.domain.services;

import me.ryzeon.chatserver.chat.domain.model.aggregates.ChatMessage;
import me.ryzeon.chatserver.chat.domain.model.commands.CreateChatMessageCommand;

import java.util.Optional;

public interface ChatMessageCommandService {

    Optional<ChatMessage> handle(CreateChatMessageCommand command);
}
