package com.java_school.MindMeal.resources_server.repository;

import com.java_school.MindMeal.resources_server.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, String> {
}
