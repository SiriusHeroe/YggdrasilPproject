package com.java_school.MindMeal.resources_server.service;

import com.java_school.MindMeal.resources_server.model.Option;
import com.java_school.MindMeal.resources_server.repository.OptionRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.*;

@Service
public class OptionServiceImpl implements OptionService {

    private final OptionRepository optionRepository;

    public OptionServiceImpl(OptionRepository optionRepository) {
        this.optionRepository = optionRepository;
    }

    @Override
    public void create(Option option) {
        optionRepository.save(option);
    }

    @Override
    public List<Option> readAll() {
        return optionRepository.findAll();
    }

    @Override
    public Option read(String id) {
        return optionRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
    }

    @Override
    public boolean update(Option option, String id) {
        if (optionRepository.existsById(id)) {
            option.setId(id);
            optionRepository.save(option);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        if (optionRepository.existsById(id)) {
            optionRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
