package me.ryzeon.chatserver.chat.domain.model.queries;

import java.util.List;

public record GetAllChatGroupById(
        List<Long> ids
) {
   public GetAllChatGroupById {
       if (ids == null) {
           throw new IllegalArgumentException("Group ID cannot be null");
       }
   }
}
