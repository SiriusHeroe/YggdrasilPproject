package com.java_school.MindMeal.repository;

import com.java_school.MindMeal.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
