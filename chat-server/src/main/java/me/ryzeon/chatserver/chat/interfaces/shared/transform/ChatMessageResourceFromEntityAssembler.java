package me.ryzeon.chatserver.chat.interfaces.shared.transform;

import lombok.experimental.UtilityClass;
import me.ryzeon.chatserver.chat.domain.model.aggregates.ChatMessage;
import me.ryzeon.chatserver.chat.interfaces.shared.resources.ChatMessageResource;

@UtilityClass
public class ChatMessageResourceFromEntityAssembler {

    public ChatMessageResource toResourceFromEntity(ChatMessage entity) {
        return new ChatMessageResource(
                entity.getId(),
                entity.getSender(),
                entity.getGroupId(),
                entity.getContent()
        );
    }
}
