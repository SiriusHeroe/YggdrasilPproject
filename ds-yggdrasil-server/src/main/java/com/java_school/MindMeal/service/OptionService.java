package com.java_school.MindMeal.service;

import com.java_school.MindMeal.model.Option;

import java.util.List;

public interface OptionService {
    /**
     * Create new option
     * @param option - option for creating
     */
    void create(Option option);

    /**
     * Return list with all option
     * @return list option
     */
    List<Option> readAll();

    /**
     * Return option by id
     * @param id - ID option
     * @return - body option by ID
     */
    Option read(String id);

    /**
     * Update option by ID,
     * @param option - new option param in json
     * @param id - id option
     * @return - true if update was success, else false
     */
    boolean update(Option option, String id);

    /**
     * Delete option by ID
     * @param id - id option
     * @return - true if option was deleted, else false
     */
    boolean delete(String id);
}
