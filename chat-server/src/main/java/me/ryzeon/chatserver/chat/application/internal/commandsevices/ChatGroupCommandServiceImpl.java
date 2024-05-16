package me.ryzeon.chatserver.chat.application.internal.commandsevices;

import me.ryzeon.chatserver.chat.domain.model.aggregates.ChatGroup;
import me.ryzeon.chatserver.chat.domain.model.commands.CreateChatGroupCommand;
import me.ryzeon.chatserver.chat.domain.services.ChatGroupCommandService;
import me.ryzeon.chatserver.chat.infrastructure.persistence.mongodb.ChatGroupRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ChatGroupCommandServiceImpl implements ChatGroupCommandService {

    private final ChatGroupRepository chatGroupRepository;

    public ChatGroupCommandServiceImpl(ChatGroupRepository chatGroupRepository) {
        this.chatGroupRepository = chatGroupRepository;
    }

    @Override
    public Optional<ChatGroup> handle(CreateChatGroupCommand command) {
        if (chatGroupRepository.existsChatGroupByName(command.name())) {
            throw new IllegalArgumentException("Chat group with name " + command.name() + " already exists");
        }
        var chatGroup = new ChatGroup(command);
        var savedChatGroup = chatGroupRepository.save(chatGroup);
        return Optional.of(savedChatGroup);
    }
}
