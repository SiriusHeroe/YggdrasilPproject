package com.java_school.MindMeal.controller;

import com.java_school.MindMeal.model.Contract;
import com.java_school.MindMeal.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("contract/api/v1")
public class ContractCotroller {
    private final ContractService contractService;

    @Autowired
    public ContractCotroller(ContractService contractService) {
        this.contractService = contractService;
    }

    @PostMapping(value = "/contracts")
    public ResponseEntity<?> create(@RequestBody Contract contract) {
        contractService.create(contract);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/contracts")
    public ResponseEntity<List<Contract>> read() {
        final List<Contract> contracts = contractService.readAll();

        return contracts != null && !contracts.isEmpty()
                ? new ResponseEntity<>(contracts, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/contracts/{id}")
    public ResponseEntity<Contract> read(@PathVariable(name = "id") String id) {
        final Contract contracts = contractService.read(id);

        return contracts != null
                ? new ResponseEntity<>(contracts, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/contracts/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") String id, @RequestBody Contract contracts) {
        final boolean updated = contractService.update(contracts, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/contracts/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") String id) {
        final boolean deleted = contractService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}