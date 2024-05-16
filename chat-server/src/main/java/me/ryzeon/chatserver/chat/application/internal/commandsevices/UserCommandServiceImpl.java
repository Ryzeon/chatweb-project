package me.ryzeon.chatserver.chat.application.internal.commandsevices;

import me.ryzeon.chatserver.chat.domain.model.aggregates.User;
import me.ryzeon.chatserver.chat.domain.model.commands.CreateUserCommand;
import me.ryzeon.chatserver.chat.domain.model.commands.JoinUserGroupCommand;
import me.ryzeon.chatserver.chat.domain.model.commands.LeaveUserGroupCommand;
import me.ryzeon.chatserver.chat.domain.services.UserCommandService;
import me.ryzeon.chatserver.chat.infrastructure.persistence.mongodb.ChatGroupRepository;
import me.ryzeon.chatserver.chat.infrastructure.persistence.mongodb.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserCommandServiceImpl implements UserCommandService {

    private final UserRepository userRepository;
    private final ChatGroupRepository groupRepository;

    public UserCommandServiceImpl(UserRepository userRepository, ChatGroupRepository groupRepository) {
        this.userRepository = userRepository;
        this.groupRepository = groupRepository;
    }

    @Override
    public Optional<User> handle(CreateUserCommand command) {
        if (userRepository.existsByNickname(command.nickname())) {
            throw new IllegalArgumentException("User with nickname " + command.nickname() + " already exists");
        }
        var user = new User(command);
        var savedUser = userRepository.save(user);
        return Optional.of(savedUser);
    }

    boolean verifyIfUserAndGroupExist(Long userId, Long groupId) {
        if (userRepository.existsById(userId)) {
            throw new IllegalArgumentException("User with id " + userId + " does not exist");
        }
        if (groupRepository.existsById(groupId)) {
            throw new IllegalArgumentException("Group with id " + groupId + " does not exist");
        }
        return true;
    }

    @Override
    public void handle(JoinUserGroupCommand command) {
        if (verifyIfUserAndGroupExist(command.userId(), command.groupId())) {
            User user = userRepository.findById(command.userId()).get();
            user.joinChatGroup(command.groupId());
            userRepository.save(user);
        }
    }

    @Override
    public void handle(LeaveUserGroupCommand command) {
        if (verifyIfUserAndGroupExist(command.userId(), command.groupId())) {
            User user = userRepository.findById(command.userId()).get();
            user.leaveChatGroup(command.groupId());
            userRepository.save(user);
        }
    }
}
