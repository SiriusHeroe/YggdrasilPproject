package com.java_school.MindMeal.controller;

import com.java_school.MindMeal.model.Customer;
import com.java_school.MindMeal.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customer/api/v1")
public class CustomerController {
    private final CustomerService CustomerService;

    @Autowired
    public CustomerController(CustomerService CustomerService) {
        this.CustomerService = CustomerService;
    }

    @PostMapping(value = "/customers")
    public ResponseEntity<?> create(@RequestBody Customer customers) {
        CustomerService.create(customers);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/customers")
    public ResponseEntity<List<Customer>> read() {
        final List<Customer> customers = CustomerService.readAll();

        return customers != null && !customers.isEmpty()
                ? new ResponseEntity<>(customers, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/customers/{id}")
    public ResponseEntity<Customer> read(@PathVariable(name = "id") String id) {
        final Customer customers = CustomerService.read(id);

        return customers != null
                ? new ResponseEntity<>(customers, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/customers/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") String id, @RequestBody Customer customers) {
        final boolean updated = CustomerService.update(customers, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/customers/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") String id) {
        final boolean deleted = CustomerService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
