package me.ryzeon.chatserver.chat.interfaces.rest;

import lombok.AllArgsConstructor;
import me.ryzeon.chatserver.chat.domain.model.queries.GetAllChatMessageByGroupId;
import me.ryzeon.chatserver.chat.domain.services.ChatMessageCommandService;
import me.ryzeon.chatserver.chat.domain.services.ChatMessageQueryService;
import me.ryzeon.chatserver.chat.interfaces.shared.resources.ChatMessageResource;
import me.ryzeon.chatserver.chat.interfaces.shared.transform.ChatMessageResourceFromEntityAssembler;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/chat-messages")
@AllArgsConstructor
public class ChatMessageController {

    private final ChatMessageCommandService chatMessagesCommandService;
    private final ChatMessageQueryService chatMessagesQueryService;
    private final SimpMessagingTemplate simpMessagingTemplate;


    @GetMapping("/")
    public ResponseEntity<Page<ChatMessageResource>> getChatMessagesByGroupId(
            @RequestParam String groupId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int sizePerPage,
            @RequestParam(defaultValue = "DESC") Sort.Direction sortDirection
    ) {
        var pageable = PageRequest.of(page, sizePerPage, Sort.by(sortDirection, "createdAt"));
        var chatMessages = chatMessagesQueryService.handle(new GetAllChatMessageByGroupId(Long.parseLong(groupId)), pageable);
        var chatMessageResources = chatMessages.map(ChatMessageResourceFromEntityAssembler::toResourceFromEntity);
        return ResponseEntity.ok(chatMessageResources);
    }

}
