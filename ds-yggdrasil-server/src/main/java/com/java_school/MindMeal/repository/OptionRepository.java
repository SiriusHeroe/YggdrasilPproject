package com.java_school.MindMeal.repository;

import com.java_school.MindMeal.model.Option;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OptionRepository extends JpaRepository<Option, String> {
}
