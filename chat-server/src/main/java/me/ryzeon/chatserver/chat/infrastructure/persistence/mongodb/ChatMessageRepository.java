package me.ryzeon.chatserver.chat.infrastructure.persistence.mongodb;

import me.ryzeon.chatserver.chat.domain.model.aggregates.ChatMessage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ChatMessageRepository extends MongoRepository<ChatMessage, Long> {

    Page<ChatMessage> findAllByGroupId(Long groupId, Pageable pageable);
}
