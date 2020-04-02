package com.java_school.MindMeal.repository;

import com.java_school.MindMeal.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {
}
