package me.ryzeon.chatserver.chat.domain.model.commands;

public record CreateUserCommand(
        String nickname,
        String description
) {
    public CreateUserCommand {
        if (nickname == null || nickname.isBlank()) {
            throw new IllegalArgumentException("Nickname cannot be null or blank");
        }
    }
}
