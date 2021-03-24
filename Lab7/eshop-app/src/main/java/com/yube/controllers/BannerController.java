package com.yube.controllers;

import com.yube.model.dto.Banner;
import com.yube.services.BannerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/banners")
@CrossOrigin(origins = "*", maxAge = 3600)
public class BannerController {

    private final BannerService bannerService;

    @GetMapping("")
    public List<Banner> getAll() {
        return bannerService.getAll();
    }

    @GetMapping("/{id}")
    public Banner getById(@PathVariable("id") String id) {
        return bannerService.getById(id);
    }

    @GetMapping("/random")
    public Banner getRandom() {
        return bannerService.getRandom();
    }
}
