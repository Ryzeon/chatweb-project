package me.ryzeon.chatserver.chat.interfaces.socket;

import lombok.AllArgsConstructor;
import me.ryzeon.chatserver.chat.domain.model.commands.JoinUserGroupCommand;
import me.ryzeon.chatserver.chat.domain.model.commands.LeaveUserGroupCommand;
import me.ryzeon.chatserver.chat.domain.services.UserCommandService;
import me.ryzeon.chatserver.chat.domain.services.UserQueryService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
public class UserSocket {

    private final UserCommandService userCommandService;
    private final UserQueryService userQueryService;

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
}