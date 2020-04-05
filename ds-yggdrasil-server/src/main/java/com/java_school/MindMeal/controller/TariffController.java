package com.java_school.MindMeal.controller;

import com.java_school.MindMeal.model.Tariff;
import com.java_school.MindMeal.service.TariffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tariff/api/v1")
public class TariffController {

    private final TariffService tariffService;

    @Autowired
    public TariffController(TariffService tariffService) {
        this.tariffService = tariffService;
    }

    @PostMapping(value = "/tariffs")
    public ResponseEntity<?> create(@RequestBody Tariff tariff) {
        tariffService.create(tariff);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/tariffs")
    public ResponseEntity<List<Tariff>> read() {
        final List<Tariff> tariffs = tariffService.readAll();

        return tariffs != null && !tariffs.isEmpty()
                ? new ResponseEntity<>(tariffs, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/tariffs/{id}")
    public ResponseEntity<Tariff> read(@PathVariable(name = "id") String id) {
        final Tariff tarifs = tariffService.read(id);

        return tarifs != null
                ? new ResponseEntity<>(tarifs, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/tariffs/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") String id, @RequestBody Tariff tariff) {
        final boolean updated = tariffService.update(tariff, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/tariffs/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") String id) {
        final boolean deleted = tariffService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
