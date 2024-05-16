package me.ryzeon.chatserver.chat.domain.model.commands;

public record LeaveUserGroupCommand(
        Long userId,
        Long groupId
) {
    public LeaveUserGroupCommand {
        if (userId == null) {
            throw new IllegalArgumentException("User ID cannot be null");
        }
        if (groupId == null) {
            throw new IllegalArgumentException("Group ID cannot be null");
        }
    }
}
