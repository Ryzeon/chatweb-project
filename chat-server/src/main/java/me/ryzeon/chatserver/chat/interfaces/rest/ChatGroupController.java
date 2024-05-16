package me.ryzeon.chatserver.chat.interfaces.rest;

import lombok.AllArgsConstructor;
import me.ryzeon.chatserver.chat.domain.services.ChatGroupCommandService;
import me.ryzeon.chatserver.chat.domain.services.ChatGroupQueryService;
import org.springframework.stereotype.Controller;

@Controller("/chat-groups")
@AllArgsConstructor
public class ChatGroupController {

    private final ChatGroupCommandService chatGroupCommandService;
    private final ChatGroupQueryService chatGroupQueryService;
}
