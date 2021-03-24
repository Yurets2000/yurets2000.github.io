package com.yube.controllers;

import com.yube.model.dto.Market;
import com.yube.services.MarketService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/markets")
@CrossOrigin(origins = "*", maxAge = 3600)
public class MarketController {

    private final MarketService marketService;

    @GetMapping("")
    public List<Market> getAll() {
        return marketService.getAll();
    }

    @GetMapping("/{id}")
    public Market getById(@PathVariable("id") String id) {
        return marketService.getById(id);
    }

    @PostMapping("")
    public Market create(@RequestBody Market market) {
        return marketService.create(market);
    }

    @PutMapping("")
    public Market update(@RequestBody Market market) {
        return marketService.update(market);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        marketService.delete(id);
    }
}
