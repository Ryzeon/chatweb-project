package me.ryzeon.chatserver.chat.domain.model.queries;

public record GetAllOnlineUserByChatGroupId(
        Long groupId
) {
    public GetAllOnlineUserByChatGroupId {
        if (groupId == null) {
            throw new IllegalArgumentException("Group ID cannot be null");
        }
    }
}
