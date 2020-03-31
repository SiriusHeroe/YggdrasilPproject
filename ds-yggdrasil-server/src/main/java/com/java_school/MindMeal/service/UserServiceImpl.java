package com.java_school.MindMeal.service;

import com.java_school.MindMeal.model.User;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService{

    // Storadge users
    private static final Map<String, User> USER_HASH_MAP = new HashMap<>();

    // Variable for generate uuid
    private static final UUID USER_UUID = null;

    @Override
    public void create(User user) {
        final String clientId = USER_UUID.randomUUID().toString();
        user.setId(clientId);
        USER_HASH_MAP.put(clientId, user);
    }

    @Override
    public List<User> readAll() {
        return new ArrayList<>(USER_HASH_MAP.values());
    }

    @Override
    public User read(String id) {
        return USER_HASH_MAP.get(id);
    }

    @Override
    public boolean update(User client, String id) {
        if (USER_HASH_MAP.containsKey(id)) {
            client.setId(id);
            USER_HASH_MAP.put(id, client);
            return true;
        }

        return false;
    }

    @Override
    public boolean delete(String id) {
        return USER_HASH_MAP.remove(id) != null;
    }
}
