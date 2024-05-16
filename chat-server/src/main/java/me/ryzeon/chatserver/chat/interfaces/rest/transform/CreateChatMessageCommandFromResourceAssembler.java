package me.ryzeon.chatserver.chat.interfaces.rest.transform;

import lombok.experimental.UtilityClass;
import me.ryzeon.chatserver.chat.domain.model.commands.CreateChatMessageCommand;
import me.ryzeon.chatserver.chat.interfaces.rest.resources.CreateChatMessageResource;

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
