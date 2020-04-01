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
        final String userId = USER_UUID.randomUUID().toString();
        user.setId(userId);
        USER_HASH_MAP.put(userId, user);
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
    public boolean update(User user, String id) {
        if (USER_HASH_MAP.containsKey(id)) {
            user.setId(id);
            USER_HASH_MAP.put(id, user);
            return true;
        }

        return false;
    }

    @Override
    public boolean delete(String id) {
        return USER_HASH_MAP.remove(id) != null;
    }
}
