package com.yube.controllers;

import com.yube.model.dto.ProductCategory;
import com.yube.services.ProductCategoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/product-categories")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ProductCategoryController {

    private final ProductCategoryService productCategoryService;

    @GetMapping("")
    public List<ProductCategory> getAll() {
        return productCategoryService.getAll();
    }

    @GetMapping("/{id}")
    public ProductCategory getById(@PathVariable("id") String id) {
        return productCategoryService.getById(id);
    }

    @GetMapping("/default")
    public ProductCategory getDefault() {
        return productCategoryService.getDefault();
    }

    @PostMapping("")
    public ProductCategory create(@RequestBody ProductCategory productCategory) {
        return productCategoryService.create(productCategory);
    }

    @PutMapping("")
    public ProductCategory update(@RequestBody ProductCategory productCategory) {
        return productCategoryService.update(productCategory);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        productCategoryService.delete(id);
    }
}
