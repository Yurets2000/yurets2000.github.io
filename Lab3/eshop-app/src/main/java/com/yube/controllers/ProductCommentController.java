package com.yube.controllers;

import com.yube.model.dto.ProductComment;
import com.yube.services.ProductCommentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/product-comments")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ProductCommentController {

    private final ProductCommentService productCommentService;

    @GetMapping("")
    public List<ProductComment> getAll() {
        return productCommentService.getAll();
    }

    @GetMapping("/{id}")
    public ProductComment getById(@PathVariable("id") String id) {
        return productCommentService.getById(id);
    }

    @PostMapping("/{productId}")
    public ProductComment create(@PathVariable("productId") String productId, @RequestBody ProductComment productComment) {
        return productCommentService.create(productId, productComment);
    }

    @PutMapping("")
    public ProductComment update(@RequestBody ProductComment productComment) {
        return productCommentService.update(productComment);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        productCommentService.delete(id);
    }
}
