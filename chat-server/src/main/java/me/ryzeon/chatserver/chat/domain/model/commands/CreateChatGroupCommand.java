package me.ryzeon.chatserver.chat.domain.model.commands;

public record CreateChatGroupCommand(
        String name
) {
    public CreateChatGroupCommand {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or blank");
        }
    }
}
