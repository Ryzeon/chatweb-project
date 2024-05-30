package me.ryzeon.chatserver.chat.interfaces.socket;

import lombok.AllArgsConstructor;
import me.ryzeon.chatserver.chat.domain.services.ChatMessageCommandService;
import me.ryzeon.chatserver.chat.domain.services.ChatMessageQueryService;
import me.ryzeon.chatserver.chat.interfaces.socket.resources.CreateChatMessageResource;
import me.ryzeon.chatserver.chat.interfaces.shared.transform.ChatMessageResourceFromEntityAssembler;
import me.ryzeon.chatserver.chat.interfaces.socket.transform.CreateChatMessageCommandFromResourceAssembler;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/chat-messages")
@AllArgsConstructor
public class ChatMessageSocket {

    private final ChatMessageCommandService chatMessagesCommandService;
    private final ChatMessageQueryService chatMessagesQueryService;
    private final SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping
    public void createChatMessage(@Payload CreateChatMessageResource resource) {
        var createChatMessageCommand = CreateChatMessageCommandFromResourceAssembler.toCommandFromResource(resource);
        var chatMessage = chatMessagesCommandService.handle(createChatMessageCommand).orElseThrow(() -> new RuntimeException("Chat message not created"));
        var chatMessageResource = ChatMessageResourceFromEntityAssembler.toResourceFromEntity(chatMessage);
        simpMessagingTemplate.convertAndSend("/topic/chat-group." + chatMessage.getGroupId(), chatMessageResource);
    }
}
