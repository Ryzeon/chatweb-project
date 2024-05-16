package me.ryzeon.chatserver.chat.interfaces.rest.transform;

import lombok.experimental.UtilityClass;
import me.ryzeon.chatserver.chat.domain.model.commands.CreateUserCommand;
import me.ryzeon.chatserver.chat.interfaces.rest.resources.CreateUserResource;

@UtilityClass
public class CreateUserCommandFromResourceAssembler {

    public CreateUserCommand toCommandFromResource(CreateUserResource resource) {
        return new CreateUserCommand(
                resource.nickname(),
                resource.description()
        );
    }
}
