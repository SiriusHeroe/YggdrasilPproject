package com.java_school.MindMeal.controller;

import com.java_school.MindMeal.model.Contract;
import com.java_school.MindMeal.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContractCotroller {
    private final ContractService contractService;

    @Autowired
    public ContractCotroller(ContractService contractService) {
        this.contractService = contractService;
    }

    @PostMapping(value = "/contract")
    public ResponseEntity<?> create(@RequestBody Contract contract) {
        contractService.create(contract);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/contract")
    public ResponseEntity<List<Contract>> read() {
        final List<Contract> contracts = contractService.readAll();

        return contracts != null &&  !contracts.isEmpty()
                ? new ResponseEntity<>(contracts, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/contract/{id}")
    public ResponseEntity<Contract> read(@PathVariable(name = "id") String id) {
        final Contract contracts = contractService.read(id);

        return contracts != null
                ? new ResponseEntity<>(contracts, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/contract/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") String  id, @RequestBody Contract contract) {
        final boolean updated = contractService.update(contract, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/contract/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") String  id) {
        final boolean deleted = contractService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
