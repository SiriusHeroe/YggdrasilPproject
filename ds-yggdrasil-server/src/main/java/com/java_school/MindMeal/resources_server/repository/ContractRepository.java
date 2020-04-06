package com.java_school.MindMeal.resources_server.repository;

import com.java_school.MindMeal.resources_server.model.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractRepository extends JpaRepository<Contract, String> {
}
