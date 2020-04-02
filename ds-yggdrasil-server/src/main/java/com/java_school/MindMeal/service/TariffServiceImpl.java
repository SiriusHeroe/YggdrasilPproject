package com.java_school.MindMeal.service;

import com.java_school.MindMeal.model.Tariff;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TariffServiceImpl implements TariffService {
    // Storadge tarif
    private static final Map<String, Tariff> TARIF_HASH_MAP = new HashMap<>();

    // Variable for generate uuid
    private static final UUID TARIF_UUID = null;

    @Override
    public void create(Tariff tariff) {
        final String tarifId = TARIF_UUID.randomUUID().toString();
        tariff.setId(tarifId);
        TARIF_HASH_MAP.put(tarifId, tariff);
    }

    @Override
    public List<Tariff> readAll() {
        return new ArrayList<>(TARIF_HASH_MAP.values());
    }

    @Override
    public Tariff read(String id) {
        return TARIF_HASH_MAP.get(id);
    }

    @Override
    public boolean update(Tariff tariff, String id) {
        if (TARIF_HASH_MAP.containsKey(id)) {
            tariff.setId(id);
            TARIF_HASH_MAP.put(id, tariff);
            return true;
        }

        return false;
    }

    @Override
    public boolean delete(String id) {
        return TARIF_HASH_MAP.remove(id) != null;
    }
}
