package me.ryzeon.chatserver.chat.interfaces.rest.resources;

public record ChatMessageResource(
        Long id,
        String sender,
        Long groupId,
        String content
) {
}
