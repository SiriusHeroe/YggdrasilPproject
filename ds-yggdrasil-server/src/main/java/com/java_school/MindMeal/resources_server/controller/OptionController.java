package com.java_school.MindMeal.resources_server.controller;

import com.java_school.MindMeal.resources_server.model.Option;
import com.java_school.MindMeal.resources_server.service.OptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("option/api/v1")
public class OptionController {

    private final OptionService optionService;

    @Autowired
    public OptionController(OptionService optionService) {
        this.optionService = optionService;
    }

    @PostMapping(value = "/option")
    public ResponseEntity<?> create(@RequestBody Option option) {
        optionService.create(option);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/option")
    public ResponseEntity<List<Option>> read() {
        final List<Option> options = optionService.readAll();

        return options != null && !options.isEmpty()
                ? new ResponseEntity<>(options, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/option/{id}")
    public ResponseEntity<Option> read(@PathVariable(name = "id") String id) {
        final Option option = optionService.read(id);

        return option != null
                ? new ResponseEntity<>(option, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/option/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") String id, @RequestBody Option option) {
        final boolean updated = optionService.update(option, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/option/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") String id) {
        final boolean deleted = optionService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
