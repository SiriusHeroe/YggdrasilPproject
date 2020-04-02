package com.java_school.MindMeal.service;

import com.java_school.MindMeal.model.Tariff;
import com.java_school.MindMeal.repository.TariffRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;


@Service
public class TariffServiceImpl implements TariffService {

    private final TariffRepository tariffRepository;

    public TariffServiceImpl(TariffRepository tariffRepository) {
        this.tariffRepository = tariffRepository;
    }

    @Override
    public void create(Tariff tariff) {
        tariffRepository.save(tariff);
    }

    @Override
    public List<Tariff> readAll() {
        return tariffRepository.findAll();
    }

    @Override
    public Tariff read(String id) {
        return tariffRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id));
    }

    @Override
    public boolean update(Tariff tariff, String id) {
        if (tariffRepository.existsById(id)) {
            tariff.setId(id);
            tariffRepository.save(tariff);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        if (tariffRepository.existsById(id)) {
            tariffRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
