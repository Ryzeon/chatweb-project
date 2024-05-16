package me.ryzeon.chatserver.chat.domain.model.queries;

public record GetAllChatMessageByGroupId(
        Long groupId
) {
    public GetAllChatMessageByGroupId {
        if (groupId == null) {
            throw new IllegalArgumentException("Group ID cannot be null");
        }
    }
}
