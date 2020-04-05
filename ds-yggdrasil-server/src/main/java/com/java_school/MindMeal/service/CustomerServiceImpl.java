package com.java_school.MindMeal.service;

import com.java_school.MindMeal.model.Customer;
import com.java_school.MindMeal.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.*;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void create(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public List<Customer> readAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer read(String id) {
        return customerRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
    }

    @Override
    public boolean update(Customer customer, String id) {
        if (customerRepository.existsById(id)) {
            customer.setId(id);
            customerRepository.save(customer);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        if (customerRepository.existsById(id)) {
            customerRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
