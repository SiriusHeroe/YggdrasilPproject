package com.java_school.MindMeal.repository;

import com.java_school.MindMeal.model.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractRepository extends JpaRepository<Contract, String> {
}
