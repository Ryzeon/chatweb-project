package me.ryzeon.chatserver.chat.application.internal.commandsevices;

import me.ryzeon.chatserver.chat.domain.model.aggregates.ChatMessage;
import me.ryzeon.chatserver.chat.domain.model.commands.CreateChatMessageCommand;
import me.ryzeon.chatserver.chat.domain.services.ChatMessageCommandService;
import me.ryzeon.chatserver.chat.infrastructure.persistence.mongodb.ChatMessageRepository;

import java.util.Optional;

public class ChatMessageCommandServiceImpl implements ChatMessageCommandService {

    private final ChatMessageRepository chatMessageRepository;

    public ChatMessageCommandServiceImpl(ChatMessageRepository chatMessageRepository) {
        this.chatMessageRepository = chatMessageRepository;
    }

    @Override
    public Optional<ChatMessage> handle(CreateChatMessageCommand command) {
        return Optional.empty();
    }
}
