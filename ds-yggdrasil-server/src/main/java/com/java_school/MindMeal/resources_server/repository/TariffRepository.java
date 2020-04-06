package com.java_school.MindMeal.resources_server.repository;

import com.java_school.MindMeal.resources_server.model.Tariff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TariffRepository extends JpaRepository<Tariff, String> {
}
