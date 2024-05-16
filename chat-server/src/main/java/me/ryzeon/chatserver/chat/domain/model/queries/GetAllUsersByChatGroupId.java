package me.ryzeon.chatserver.chat.domain.model.queries;

public record GetAllUsersByChatGroupId(
        Long groupId
) {
    public GetAllUsersByChatGroupId {
        if (groupId == null) {
            throw new IllegalArgumentException("Group ID cannot be null");
        }
    }
}
