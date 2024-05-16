package me.ryzeon.chatserver.chat.domain.model.aggregates;

import lombok.Getter;
import me.ryzeon.chatserver.chat.domain.model.commands.CreateChatMessageCommand;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "chat_messages")
@Getter
public class ChatMessage {

    @Id
    private Long id;
    private String sender;
    private Long groupId;
    private String content;

    @CreatedDate
    private Date createdAt;

    protected ChatMessage() {
    }

    public ChatMessage(CreateChatMessageCommand command) {
        this.sender = command.sender();
        this.groupId = command.groupId();
        this.content = command.content();
    }
}
