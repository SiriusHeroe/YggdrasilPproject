package com.java_school.MindMeal.service;

import com.java_school.MindMeal.model.Option;

import java.util.*;

public class OptionServiceImpl implements OptionService {
    // Storadge option
    private static final Map<String, Option> OPTION_HASH_MAP = new HashMap<>();

    // Variable for generate uuid
    private static final UUID OPTION_UUID = null;

    @Override
    public void create(Option option) {
        final String optionId = OPTION_UUID.randomUUID().toString();
        option.setId(optionId);
        OPTION_HASH_MAP.put(optionId, option);
    }

    @Override
    public List<Option> readAll() {
        return new ArrayList<>(OPTION_HASH_MAP.values());
    }

    @Override
    public Option read(String id) {
        return OPTION_HASH_MAP.get(id);
    }

    @Override
    public boolean update(Option option, String id) {
        if (OPTION_HASH_MAP.containsKey(id)) {
            option.setId(id);
            OPTION_HASH_MAP.put(id, option);
            return true;
        }

        return false;
    }

    @Override
    public boolean delete(String id) {
        return OPTION_HASH_MAP.remove(id) != null;
    }
}
