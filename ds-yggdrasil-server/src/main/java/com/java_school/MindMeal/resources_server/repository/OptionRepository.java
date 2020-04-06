package com.java_school.MindMeal.resources_server.repository;

import com.java_school.MindMeal.resources_server.model.Option;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OptionRepository extends JpaRepository<Option, String> {
}
