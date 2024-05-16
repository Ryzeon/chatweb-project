package me.ryzeon.chatserver.chat.interfaces.rest.transform;

import me.ryzeon.chatserver.chat.domain.model.commands.CreateUserCommand;
import me.ryzeon.chatserver.chat.interfaces.rest.resources.CreateUserResource;

public class CreateUserCommandFromResourceAssembler {

    public CreateUserCommand toCommandFromResource(CreateUserResource resource) {
        return new CreateUserCommand(
                resource.nickname(),
                resource.description()
        );
    }
}
