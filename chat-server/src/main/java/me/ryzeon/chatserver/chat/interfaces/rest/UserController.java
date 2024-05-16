package me.ryzeon.chatserver.chat.interfaces.rest;

import lombok.AllArgsConstructor;
import me.ryzeon.chatserver.chat.domain.model.aggregates.User;
import me.ryzeon.chatserver.chat.domain.model.commands.JoinUserGroupCommand;
import me.ryzeon.chatserver.chat.domain.model.commands.LeaveUserGroupCommand;
import me.ryzeon.chatserver.chat.domain.model.queries.GetAllOnlineUserByChatGroupId;
import me.ryzeon.chatserver.chat.domain.model.queries.GetAllUsersByChatGroupId;
import me.ryzeon.chatserver.chat.domain.services.UserCommandService;
import me.ryzeon.chatserver.chat.domain.services.UserQueryService;
import me.ryzeon.chatserver.chat.interfaces.rest.resources.CreateUserResource;
import me.ryzeon.chatserver.chat.interfaces.rest.resources.UserResource;
import me.ryzeon.chatserver.chat.interfaces.rest.transform.CreateUserCommandFromResourceAssembler;
import me.ryzeon.chatserver.chat.interfaces.rest.transform.UserResourceFromEntityAssembler;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller()
@AllArgsConstructor
public class UserController {

    private final UserCommandService userCommandService;
    private final UserQueryService userQueryService;

    @MessageMapping("/user.create")
    @SendTo("/user/topic")
    public UserResource createUser(CreateUserResource resource) {
        var createUserCommand = CreateUserCommandFromResourceAssembler.toCommandFromResource(resource);
        return userCommandService.handle(createUserCommand)
                .map(UserResourceFromEntityAssembler::toResourceFromEntity)
                .orElse(null);
    }

    @MessageMapping("/user.leaveFromGroup")
    @SendTo("/user/topic")
    public void leaveUserFromGroup(Long userId, Long chatGroupId) {
        var leaveUserGroupCommand = new LeaveUserGroupCommand(userId, chatGroupId);
        userCommandService.handle(leaveUserGroupCommand);
    }

    @MessageMapping("/user.joinToGroup")
    @SendTo("/user/topic")
    public void joinUserToGroup(Long userId, Long chatGroupId) {
        var joinUserGroupCommand = new JoinUserGroupCommand(userId, chatGroupId);
        userCommandService.handle(joinUserGroupCommand);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> findAllUsersByGroup(
            @RequestParam Map<String, String> params
    ) {
        if (params.containsKey("chatGroupId")) {
            if (params.containsKey("online")) {
                return ResponseEntity.ok(userQueryService.handle(new GetAllOnlineUserByChatGroupId(Long.parseLong(params.get("chatGroupId")))));
            } else {
                return ResponseEntity.ok(userQueryService.handle(new GetAllUsersByChatGroupId(Long.parseLong(params.get("chatGroupId")))));
            }
        }
        return ResponseEntity.notFound().build();
    }
}
