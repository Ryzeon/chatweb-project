package me.ryzeon.chatserver.chat.interfaces.rest.resources;

import java.util.Date;
import java.util.List;

public record UserResource(
        Long id,
        String nickname,
        String description,
        String status,
        List<Long> chatGroups,
        Date createdAt
) {
}
