package com.java_school.MindMeal.service;

import com.java_school.MindMeal.model.Customer;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CustomerServiceImpl implements CustomerService {
    // Storadge Customers
    private static final Map<String, Customer> CUSTOMER_HASH_MAP = new HashMap<>();

    // Variable for generate uuid
    private static final UUID CUSTOMER_UUID = null;

    @Override
    public void create(Customer customer) {
        final String customerId = CUSTOMER_UUID.randomUUID().toString();
        customer.setId(customerId);
        CUSTOMER_HASH_MAP.put(customerId, customer);
    }

    @Override
    public List<Customer> readAll() {
        return new ArrayList<>(CUSTOMER_HASH_MAP.values());
    }

    @Override
    public Customer read(String id) {
        return CUSTOMER_HASH_MAP.get(id);
    }

    @Override
    public boolean update(Customer customer, String id) {
        if (CUSTOMER_HASH_MAP.containsKey(id)) {
            customer.setId(id);
            CUSTOMER_HASH_MAP.put(id, customer);
            return true;
        }

        return false;
    }

    @Override
    public boolean delete(String id) {
        return CUSTOMER_HASH_MAP.remove(id) != null;
    }
}
