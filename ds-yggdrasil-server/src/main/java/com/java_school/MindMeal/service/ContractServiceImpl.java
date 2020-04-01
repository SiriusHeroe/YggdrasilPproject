package com.java_school.MindMeal.service;

import com.java_school.MindMeal.model.Contract;

import java.util.*;

public class ContractServiceImpl implements ContractService{
    // Storadge Contracts
    private static final Map<String, Contract> CONTRACT_HASH_MAP = new HashMap<>();

    // Variable for generate uuid
    private static final UUID CONTRACT_UUID = null;

    @Override
    public void create(Contract contract) {
        final String ContractId = CONTRACT_UUID.randomUUID().toString();
        contract.setId(ContractId);
        CONTRACT_HASH_MAP.put(ContractId, contract);
    }

    @Override
    public List<Contract> readAll() {
        return new ArrayList<>(CONTRACT_HASH_MAP.values());
    }

    @Override
    public Contract read(String id) {
        return CONTRACT_HASH_MAP.get(id);
    }

    @Override
    public boolean update(Contract contract, String id) {
        if (CONTRACT_HASH_MAP.containsKey(id)) {
            contract.setId(id);
            CONTRACT_HASH_MAP.put(id, contract);
            return true;
        }

        return false;
    }

    @Override
    public boolean delete(String id) {
        return CONTRACT_HASH_MAP.remove(id) != null;
    }
}
