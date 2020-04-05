package com.server.api.data.user;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import com.server.api.domain.user.NewUser;
import com.server.api.domain.user.User;
import com.server.api.domain.user.UserRepository;

public class InMemoryUserRepository implements UserRepository {

    private static final Map USERS_STORE = new ConcurrentHashMap();

    @Override
    public String create(NewUser newUser) {
        String id = UUID.randomUUID().toString();
        User user = User.builder()
                .id(id)
                .login(newUser.getLogin())
                .password(newUser.getPassword())
                .build();
        USERS_STORE.put(newUser.getLogin(), user);

        return id;
    }
}
