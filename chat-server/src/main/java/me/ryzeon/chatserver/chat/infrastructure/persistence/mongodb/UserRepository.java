package me.ryzeon.chatserver.chat.infrastructure.persistence.mongodb;

import me.ryzeon.chatserver.chat.domain.model.aggregates.User;
import me.ryzeon.chatserver.chat.domain.model.aggregates.UserStatus;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User, Long> {

    boolean existsByNickname(String nickname);

    List<User> getAllByStatusIs(UserStatus status);

    List<User> getAllByChatGroupsContains(Long chatGroupId);

    List<User> getAllByChatGroupsContainsAndStatusIs(Long chatGroupId, UserStatus status);
}
