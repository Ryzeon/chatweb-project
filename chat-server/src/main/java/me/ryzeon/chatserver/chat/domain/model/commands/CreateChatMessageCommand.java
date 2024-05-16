package me.ryzeon.chatserver.chat.domain.model.commands;

public record CreateChatMessageCommand(
        String sender,
        Long groupId,
        String content
) {
    public CreateChatMessageCommand {
        if (sender == null || sender.isBlank()) {
            throw new IllegalArgumentException("Sender cannot be null or blank");
        }
        if (groupId == null) {
            throw new IllegalArgumentException("Group ID cannot be null");
        }
        if (content == null || content.isBlank()) {
            throw new IllegalArgumentException("Content cannot be null or blank");
        }
    }
}
