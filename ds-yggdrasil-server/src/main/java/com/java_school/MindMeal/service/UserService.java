package com.java_school.MindMeal.service;

import com.java_school.MindMeal.model.User;

import java.util.List;
import java.util.UUID;

public interface UserService {

    /**
     * Create new user
     *
     * @param user - user for creating
     */
    void create(User user);

    /**
     * Return list with all users
     *
     * @return list users
     */
    List<User> readAll();

    /**
     * Return user by id
     *
     * @param id - ID user
     * @return - body user by ID
     */
    User read(String id);

    /**
     * Update user by ID,
     *
     * @param user - new user param in json
     * @param id   - id user
     * @return - true if update was success, else false
     */
    boolean update(User user, String id);

    /**
     * Delete user by ID
     *
     * @param id - id user
     * @return - true if user was deleted, else false
     */
    boolean delete(String id);
}