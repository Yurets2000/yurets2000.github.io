package com.yube.controllers;

import com.yube.model.dto.Product;
import com.yube.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/products")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ProductController {

    private final ProductService productService;

    @GetMapping("")
    public List<Product> getAll() {
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable("id") String id) {
        return productService.getById(id);
    }

    @PostMapping("/{productCategoryId}")
    public Product create(@PathVariable("productCategoryId") String productCategoryId, @RequestBody Product product) {
        return productService.create(productCategoryId, product);
    }

    @PutMapping("")
    public Product update(@RequestBody Product product) {
        return productService.update(product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        productService.delete(id);
    }
}
