package com.java_school.MindMeal.service;

import com.java_school.MindMeal.model.Tarif;

import java.util.List;

public interface TarifService {
    /**
     * Create new Tarif
     * @param tarif - Tarif for creating
     */
    void create(Tarif tarif);

    /**
     * Return list with all Tarifs
     * @return list Tarifs
     */
    List<Tarif> readAll();

    /**
     * Return Tarif by id
     * @param id - ID Tarif
     * @return - body Tarif by ID
     */
    Tarif read(String id);

    /**
     * Update Tarif by ID,
     * @param tarif - new Tarif param in json
     * @param id - id Tarif
     * @return - true if update was success, else false
     */
    boolean update(Tarif tarif, String id);

    /**
     * Delete Tarif by ID
     * @param id - id Tarif
     * @return - true if Tarif was deleted, else false
     */
    boolean delete(String id);
}
