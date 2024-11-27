package org.telran.shop.de.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.telran.shop.de.entity.Product;
import org.telran.shop.de.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;


// GET -----------------------------------------------------------------------------------------------------------------

    @GetMapping //  http://localhost:8080/api/products + GET
    public List<Product> getAll() {
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable long id) {
        return productService.getById(id);
    }

    @GetMapping("/filter")
    public List<Product> getByType (@RequestParam (name = "type") String type) {
        return productService.getByType(type);
    }

    @GetMapping("/title/{title}")
    public Product getByTitle (@PathVariable String title) {
        return productService.getByTitle(title);
    }

// POST ----------------------------------------------------------------------------------------------------------------

    @PostMapping
    public Product put (@RequestBody Product product) {
        return productService.put(product);
    }

    @PutMapping("/{id}")
    public Product update (@PathVariable long id, @RequestBody Product product) {
        return productService.update(id, product);
    }

// DELETE --------------------------------------------------------------------------------------------------------------

    @DeleteMapping("/{id}")
    public Product deleteById (@PathVariable long id) {
        return productService.deleteById(id);
    }

    @DeleteMapping("/title/{title}")
    public Product deleteByTitle (@PathVariable String title) {
        return productService.deleteByTitle(title);
    }
}

