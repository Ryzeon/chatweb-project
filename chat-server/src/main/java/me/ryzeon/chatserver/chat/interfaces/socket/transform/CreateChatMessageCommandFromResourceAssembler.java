package me.ryzeon.chatserver.chat.interfaces.socket.transform;

import lombok.experimental.UtilityClass;
import me.ryzeon.chatserver.chat.domain.model.commands.CreateChatMessageCommand;
import me.ryzeon.chatserver.chat.interfaces.socket.resources.CreateChatMessageResource;

@UtilityClass
public class CreateChatMessageCommandFromResourceAssembler {

    public CreateChatMessageCommand toCommandFromResource(CreateChatMessageResource resource) {
        return new CreateChatMessageCommand(
                resource.sender(),
                resource.groupId(),
                resource.content()
        );
    }
}
