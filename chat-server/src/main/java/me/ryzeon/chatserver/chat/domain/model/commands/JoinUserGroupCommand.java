package me.ryzeon.chatserver.chat.domain.model.commands;

public record JoinUserGroupCommand(
        Long userId,
        Long groupId
) {
    public JoinUserGroupCommand {
        if (userId == null) {
            throw new IllegalArgumentException("User ID cannot be null");
        }
        if (groupId == null) {
            throw new IllegalArgumentException("Group ID cannot be null");
        }
    }
}
