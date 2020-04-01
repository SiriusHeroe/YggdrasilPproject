package com.java_school.MindMeal.service;

import com.java_school.MindMeal.model.Contract;

import java.util.List;

public interface ContractService {
    /**
     * Create new Contract
     * @param contract - Contract for creating
     */
    void create(Contract contract);

    /**
     * Return list with all Contracts
     * @return list Contracts
     */
    List<Contract> readAll();

    /**
     * Return Contract by id
     * @param id - ID Contract
     * @return - body Contract by ID
     */
    Contract read(String id);

    /**
     * Update Contract by ID,
     * @param contract - new Contract param in json
     * @param id - id Contract
     * @return - true if update was success, else false
     */
    boolean update(Contract contract, String id);

    /**
     * Delete Contract by ID
     * @param id - id Contract
     * @return - true if Contract was deleted, else false
     */
    boolean delete(String id);
}
