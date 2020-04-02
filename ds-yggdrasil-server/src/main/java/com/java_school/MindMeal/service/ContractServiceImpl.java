package com.java_school.MindMeal.service;

import com.java_school.MindMeal.model.Contract;
import com.java_school.MindMeal.model.User;
import com.java_school.MindMeal.repository.ContractRepository;
import com.java_school.MindMeal.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.*;

@Service
public class ContractServiceImpl implements ContractService{

    private final ContractRepository contractRepository;

    public ContractServiceImpl(ContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }

    @Override
    public void create(Contract contract) {
        contractRepository.save(contract);
    }

    @Override
    public List<Contract> readAll() {
        return contractRepository.findAll();
    }

    @Override
    public Contract read(String id) {
        return contractRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
    }

    @Override
    public boolean update(Contract contract, String id) {
        if (contractRepository.existsById(id)) {
            contract.setId(id);
            contractRepository.save(contract);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        if (contractRepository.existsById(id)) {
            contractRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
