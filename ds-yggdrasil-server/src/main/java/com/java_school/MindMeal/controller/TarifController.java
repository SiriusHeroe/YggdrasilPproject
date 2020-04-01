package com.java_school.MindMeal.controller;

import com.java_school.MindMeal.model.Tarif;
import com.java_school.MindMeal.service.TarifService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TarifController {

    private final TarifService tarifServicee;

    @Autowired
    public TarifController(TarifService tarifServicee) {
        this.tarifServicee = tarifServicee;
    }

    @PostMapping(value = "/tarifs")
    public ResponseEntity<?> create(@RequestBody Tarif tarif) {
        tarifServicee.create(tarif);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/tarifs")
    public ResponseEntity<List<Tarif>> read() {
        final List<Tarif> tarifs = tarifServicee.readAll();

        return tarifs != null &&  !tarifs.isEmpty()
                ? new ResponseEntity<>(tarifs, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/tarifs/{id}")
    public ResponseEntity<Tarif> read(@PathVariable(name = "id") String id) {
        final Tarif tarifs = tarifServicee.read(id);

        return tarifs != null
                ? new ResponseEntity<>(tarifs, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/tarifs/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") String  id, @RequestBody Tarif tarif) {
        final boolean updated = tarifServicee.update(tarif, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/tarif/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") String  id) {
        final boolean deleted = tarifServicee.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
