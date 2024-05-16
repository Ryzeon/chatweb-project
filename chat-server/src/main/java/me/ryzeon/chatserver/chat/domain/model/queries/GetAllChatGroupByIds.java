package me.ryzeon.chatserver.chat.domain.model.queries;

import java.util.List;

public record GetAllChatGroupByIds(
        List<Long> ids
) {
   public GetAllChatGroupByIds {
       if (ids == null) {
           throw new IllegalArgumentException("Group ID cannot be null");
       }
   }
}
