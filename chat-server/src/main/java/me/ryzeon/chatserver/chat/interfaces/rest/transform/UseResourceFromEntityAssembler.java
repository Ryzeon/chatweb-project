package me.ryzeon.chatserver.chat.interfaces.rest.transform;

import me.ryzeon.chatserver.chat.domain.model.aggregates.User;
import me.ryzeon.chatserver.chat.interfaces.rest.resources.UserResource;

public class UseResourceFromEntityAssembler {

    public static UserResource toResourceFromEntity(User entity) {
        return new UserResource(
                entity.getId(),
                entity.getNickname(),
                entity.getDescription(),
                entity.getStatus().name(),
                entity.getChatGroups(),
                entity.getCreatedAt()
        );
    }
}
