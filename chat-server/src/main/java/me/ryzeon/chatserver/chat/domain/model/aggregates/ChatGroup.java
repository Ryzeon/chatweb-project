package me.ryzeon.chatserver.chat.domain.model.aggregates;

import lombok.Getter;
import me.ryzeon.chatserver.chat.domain.model.commands.CreateChatGroupCommand;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "chat_groups")
@Getter
public class ChatGroup {

    @Id
    private Long id;
    private String name;

    protected ChatGroup() {
    }

    public ChatGroup(CreateChatGroupCommand createChatGroupCommand) {
        this.name = createChatGroupCommand.name();
    }
}
