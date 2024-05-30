package me.ryzeon.chatserver.chat.interfaces.shared.resources;

public record ChatMessageResource(
        Long id,
        String sender,
        Long groupId,
        String content
) {
}
