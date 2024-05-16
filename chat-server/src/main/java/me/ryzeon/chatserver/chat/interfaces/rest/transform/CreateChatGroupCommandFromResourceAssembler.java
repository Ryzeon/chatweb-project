package me.ryzeon.chatserver.chat.interfaces.rest.transform;

import lombok.experimental.UtilityClass;
import me.ryzeon.chatserver.chat.domain.model.commands.CreateChatGroupCommand;
import me.ryzeon.chatserver.chat.interfaces.rest.resources.CreateChatGroupResource;

@UtilityClass
public class CreateChatGroupCommandFromResourceAssembler {

    public CreateChatGroupCommand toCommandFromResource(CreateChatGroupResource resource) {
        return new CreateChatGroupCommand(
                resource.name()
        );
    }
}
