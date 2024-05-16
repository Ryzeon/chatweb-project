package me.ryzeon.chatserver.chat.infrastructure.persistence.mongodb;

import me.ryzeon.chatserver.chat.domain.model.aggregates.ChatGroup;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ChatGroupRepository extends MongoRepository<ChatGroup, Long> {

    boolean existsChatGroupByName(String name);
}
