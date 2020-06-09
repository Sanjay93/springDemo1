package dev.naman.interviewbitclone.services;

import dev.naman.interviewbitclone.models.User;
import dev.naman.interviewbitclone.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    UserService(@Qualifier("postgres") UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        return userRepository.createUser(user);
    }

    public User getUser(UUID id) {
        Optional<User> foundUser = userRepository.getUserByID(id);

        if(foundUser.isEmpty()) {
            return null;
        }

        return foundUser.get();
    }
}
