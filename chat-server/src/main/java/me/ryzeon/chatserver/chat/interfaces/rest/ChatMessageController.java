package me.ryzeon.chatserver.chat.interfaces.rest;

import lombok.AllArgsConstructor;
import me.ryzeon.chatserver.chat.domain.services.ChatMessageCommandService;
import me.ryzeon.chatserver.chat.domain.services.ChatMessageQueryService;
import org.springframework.stereotype.Controller;

@Controller("/chat-messages")
@AllArgsConstructor
public class ChatMessageController {

    private final ChatMessageCommandService chatMessagesCommandService;
    private final ChatMessageQueryService chatMessagesQueryService;


}
