package com.java_school.MindMeal.service;

import com.java_school.MindMeal.model.Customer;

import java.util.List;

public interface CustomerService {

    /**
     * Create new customer
     *
     * @param customer - customer for creating
     */
    void create(Customer customer);

    /**
     * Return list with all customer
     *
     * @return list customer
     */
    List<Customer> readAll();

    /**
     * Return customer by id
     *
     * @param id - ID user
     * @return - body customer by ID
     */
    Customer read(String id);

    /**
     * Update customer by ID,
     *
     * @param customer - new customer param in json
     * @param id       - id customer
     * @return - true if update was success, else false
     */
    boolean update(Customer customer, String id);

    /**
     * Delete customer by ID
     *
     * @param id - id customer
     * @return - true if customer was deleted, else false
     */
    boolean delete(String id);
}
