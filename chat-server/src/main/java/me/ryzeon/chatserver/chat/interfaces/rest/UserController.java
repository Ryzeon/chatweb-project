package me.ryzeon.chatserver.chat.interfaces.rest;

import me.ryzeon.chatserver.chat.domain.services.UserCommandService;
import org.springframework.stereotype.Controller;

@Controller()
public class UserController {

    private final UserCommandService userCommandService;

    public UserController(UserCommandService userCommandService) {
        this.userCommandService = userCommandService;
    }


}
