package com.yube.controllers;

import com.yube.model.dto.CharacteristicGroup;
import com.yube.services.CharacteristicGroupService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/characteristic-groups")
@CrossOrigin(origins = "*", maxAge = 3600)
public class CharacteristicGroupController {

    private final CharacteristicGroupService characteristicGroupService;

    @GetMapping("")
    public List<CharacteristicGroup> getAll() {
        return characteristicGroupService.getAll();
    }

    @GetMapping("/{id}")
    public CharacteristicGroup getById(@PathVariable("id") String id) {
        return characteristicGroupService.getById(id);
    }

    @PostMapping("")
    public CharacteristicGroup create(@RequestBody CharacteristicGroup characteristicGroup) {
        return characteristicGroupService.create(characteristicGroup);
    }

    @PutMapping("")
    public CharacteristicGroup update(@RequestBody CharacteristicGroup characteristicGroup) {
        return characteristicGroupService.update(characteristicGroup);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        characteristicGroupService.delete(id);
    }
}
