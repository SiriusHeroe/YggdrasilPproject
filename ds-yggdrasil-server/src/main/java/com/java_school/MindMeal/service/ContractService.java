package com.java_school.MindMeal.service;

import com.java_school.MindMeal.model.Contract;


import java.util.List;

public interface ContractService {
    /**
     * Create new contract
     * @param contract - contract for creating
     */
    void create(Contract contract);

    /**
     * Return list with all contracts
     * @return list contracts
     */
    List<Contract> readAll();

    /**
     * Return contract by id
     * @param id - ID contract
     * @return - body contract by ID
     */
    Contract read(String id);

    /**
     * Update contract by ID,
     * @param contract - new contract param in json
     * @param id - id contract
     * @return - true if update was success, else false
     */
    boolean update(Contract contract, String id);

    /**
     * Delete contract by ID
     * @param id - id contract
     * @return - true if contract was deleted, else false
     */
    boolean delete(String id);
}