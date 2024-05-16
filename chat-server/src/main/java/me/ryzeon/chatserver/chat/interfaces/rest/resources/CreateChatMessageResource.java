package me.ryzeon.chatserver.chat.interfaces.rest.resources;

public record CreateChatMessageResource(
        String sender,
        Long groupId,
        String content
) {
}
