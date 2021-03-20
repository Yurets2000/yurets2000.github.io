package com.yube.controllers;

import com.yube.model.dto.Characteristic;
import com.yube.services.CharacteristicService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/characteristics")
@CrossOrigin(origins = "*", maxAge = 3600)
public class CharacteristicController {

    private final CharacteristicService characteristicService;

    @GetMapping("")
    public List<Characteristic> getAll() {
        return characteristicService.getAll();
    }

    @GetMapping("/{id}")
    public Characteristic getById(@PathVariable("id") String id) {
        return characteristicService.getById(id);
    }

    @PostMapping("/{characteristicGroupId}")
    public Characteristic create(@PathVariable("characteristicGroupId") String characteristicGroupId, @RequestBody Characteristic characteristic) {
        return characteristicService.create(characteristicGroupId, characteristic);
    }

    @PutMapping("")
    public Characteristic update(@RequestBody Characteristic characteristic) {
        return characteristicService.update(characteristic);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        characteristicService.delete(id);
    }
}
