package com.java_school.MindMeal.repository;

import com.java_school.MindMeal.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, String> {
}
