package me.ryzeon.chatserver.chat.interfaces.rest;

import lombok.AllArgsConstructor;
import me.ryzeon.chatserver.chat.domain.model.queries.GetAllChatGroupByIds;
import me.ryzeon.chatserver.chat.domain.services.ChatGroupCommandService;
import me.ryzeon.chatserver.chat.domain.services.ChatGroupQueryService;
import me.ryzeon.chatserver.chat.interfaces.rest.resources.ChatGroupResource;
import me.ryzeon.chatserver.chat.interfaces.rest.resources.CreateChatGroupResource;
import me.ryzeon.chatserver.chat.interfaces.rest.transform.ChatGroupResourceFromEntityAssembler;
import me.ryzeon.chatserver.chat.interfaces.rest.transform.CreateChatGroupCommandFromResourceAssembler;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@Controller
@RequestMapping("/chat-groups")
@AllArgsConstructor
public class ChatGroupController {

    private final ChatGroupCommandService chatGroupCommandService;
    private final ChatGroupQueryService chatGroupQueryService;

    @GetMapping
    public ResponseEntity<List<ChatGroupResource>> getChatGroups(
            @RequestParam
            List<String> groupId) {
        var chatGroups = chatGroupQueryService.handle(new GetAllChatGroupByIds(groupId.stream().map(Long::parseLong).toList()));
        var chatGroupResources = chatGroups.stream().map(ChatGroupResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(chatGroupResources);
    }

    @PostMapping
    public ResponseEntity<ChatGroupResource> createChatGroup(
            @RequestBody CreateChatGroupResource resource
    ) {
        var createChatGroupCommand = CreateChatGroupCommandFromResourceAssembler.toCommandFromResource(resource);
        var chatGroup = chatGroupCommandService.handle(createChatGroupCommand);
        var chatGroupResource = chatGroup.map(ChatGroupResourceFromEntityAssembler::toResourceFromEntity)
                .orElse(null);
        if (chatGroupResource != null)
            return new ResponseEntity<>(chatGroupResource, CREATED);
        return ResponseEntity.badRequest().build();
    }
}
