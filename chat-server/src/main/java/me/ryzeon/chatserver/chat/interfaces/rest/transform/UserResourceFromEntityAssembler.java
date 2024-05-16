package me.ryzeon.chatserver.chat.interfaces.rest.transform;

import lombok.experimental.UtilityClass;
import me.ryzeon.chatserver.chat.domain.model.aggregates.User;
import me.ryzeon.chatserver.chat.interfaces.rest.resources.UserResource;

@UtilityClass
public class UserResourceFromEntityAssembler {

    public UserResource toResourceFromEntity(User entity) {
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
