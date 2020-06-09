package dev.naman.interviewbitclone.repository;


import dev.naman.interviewbitclone.models.User;
import dev.naman.interviewbitclone.utils.Constants;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class UserRepositoryPostgresImpl implements UserRepository {
    private List<User> userDatabase = new ArrayList<>();


    @Override
    public User createUser(User user) {

        User createdUser = new User(user.getName(), user.getGender());
        userDatabase.add(createdUser);
        return createdUser;
    }

    @Override
    public Optional<User> getUserByID(UUID id) {
        return userDatabase
                .stream()
                .filter(
                        user -> user.getUuid().equals(id)
                ).findFirst();
    }
}
