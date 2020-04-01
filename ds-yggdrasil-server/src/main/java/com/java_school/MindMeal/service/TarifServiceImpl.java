package com.java_school.MindMeal.service;

import com.java_school.MindMeal.model.Tarif;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TarifServiceImpl implements TarifService{
    // Storadge tarif
    private static final Map<String, Tarif> TARIF_HASH_MAP = new HashMap<>();

    // Variable for generate uuid
    private static final UUID TARIF_UUID = null;

    @Override
    public void create(Tarif tarif) {
        final String tarifId = TARIF_UUID.randomUUID().toString();
        tarif.setId(tarifId);
        TARIF_HASH_MAP.put(tarifId, tarif);
    }

    @Override
    public List<Tarif> readAll() {
        return new ArrayList<>(TARIF_HASH_MAP.values());
    }

    @Override
    public Tarif read(String id) {
        return TARIF_HASH_MAP.get(id);
    }

    @Override
    public boolean update(Tarif tarif, String id) {
        if (TARIF_HASH_MAP.containsKey(id)) {
            tarif.setId(id);
            TARIF_HASH_MAP.put(id, tarif);
            return true;
        }

        return false;
    }

    @Override
    public boolean delete(String id) {
        return TARIF_HASH_MAP.remove(id) != null;
    }
}
