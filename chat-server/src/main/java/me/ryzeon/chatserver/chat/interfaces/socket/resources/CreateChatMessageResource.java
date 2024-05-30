package me.ryzeon.chatserver.chat.interfaces.socket.resources;

public record CreateChatMessageResource(
        String sender,
        Long groupId,
        String content
) {
}
