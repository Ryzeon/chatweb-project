package me.ryzeon.chatserver.chat.domain.model.aggregates;

import lombok.Getter;
import me.ryzeon.chatserver.chat.domain.model.commands.CreateUserCommand;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document("users")
@Getter
public class User {

    @Id
    private Long id;

    private String nickname;

    private String description;

    private UserStatus status;

    private List<Long> chatGroups;

    @CreatedDate
    private Date createdAt;

    protected User() {
    }

    public User(CreateUserCommand command) {
        this.nickname = command.nickname();
        this.description = command.description();
        this.status = UserStatus.OFFLINE;
        this.chatGroups = List.of();
    }

    public void joinChatGroup(Long chatGroupId) {
        if (chatGroups.contains(chatGroupId)) {
            throw new IllegalArgumentException("User is already in chat group " + chatGroupId);
        }
        chatGroups.add(chatGroupId);
    }

    public void leaveChatGroup(Long chatGroupId) {
        chatGroups.remove(chatGroupId);
    }
}
