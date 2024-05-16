package me.ryzeon.chatserver.chat.interfaces.rest.transform;

import lombok.experimental.UtilityClass;
import me.ryzeon.chatserver.chat.domain.model.aggregates.ChatGroup;
import me.ryzeon.chatserver.chat.interfaces.rest.resources.ChatGroupResource;

@UtilityClass
public class ChatGroupResourceFromEntityAssembler {

    public ChatGroupResource toResourceFromEntity(ChatGroup entity) {
        return new ChatGroupResource(
                entity.getId(),
                entity.getName()
        );
    }
}
