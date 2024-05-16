package me.ryzeon.chatserver.chat.interfaces.rest.resources;

public record CreateUserResource(
        String nickname,
        String description
) {
}
