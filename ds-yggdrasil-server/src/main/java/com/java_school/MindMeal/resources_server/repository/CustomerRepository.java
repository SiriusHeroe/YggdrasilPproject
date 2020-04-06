package com.java_school.MindMeal.resources_server.repository;

import com.java_school.MindMeal.resources_server.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {
}
