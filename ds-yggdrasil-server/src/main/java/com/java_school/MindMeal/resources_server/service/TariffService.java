package com.java_school.MindMeal.resources_server.service;

import com.java_school.MindMeal.resources_server.model.Tariff;

import java.util.List;

public interface TariffService {
    /**
     * Create new Tarif
     *
     * @param tariff - Tarif for creating
     */
    void create(Tariff tariff);

    /**
     * Return list with all Tarifs
     *
     * @return list Tarifs
     */
    List<Tariff> readAll();

    /**
     * Return Tarif by id
     *
     * @param id - ID Tarif
     * @return - body Tarif by ID
     */
    Tariff read(String id);

    /**
     * Update Tarif by ID,
     *
     * @param tariff - new Tarif param in json
     * @param id     - id Tarif
     * @return - true if update was success, else false
     */
    boolean update(Tariff tariff, String id);

    /**
     * Delete Tarif by ID
     *
     * @param id - id Tarif
     * @return - true if Tarif was deleted, else false
     */
    boolean delete(String id);
}
