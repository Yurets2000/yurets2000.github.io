package com.yube.controllers;

import com.yube.model.dto.Offering;
import com.yube.services.OfferingService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/offerings")
@CrossOrigin(origins = "*", maxAge = 3600)
public class OfferingController {

    private final OfferingService offeringService;

    @GetMapping("")
    public List<Offering> getAll() {
        return offeringService.getAll();
    }

    @GetMapping("/{id}")
    public Offering getById(@PathVariable("id") String id) {
        return offeringService.getById(id);
    }

    @GetMapping("/default")
    public Offering getDefault() {
        return offeringService.getDefault();
    }

    @PostMapping("")
    public Offering create(@RequestBody Offering offering) {
        return offeringService.create(offering);
    }

    @PutMapping("")
    public Offering update(@RequestBody Offering offering) {
        return offeringService.update(offering);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        offeringService.delete(id);
    }
}
