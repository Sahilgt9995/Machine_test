package com.java.machine_test.Controller;

import com.java.machine_test.Entity.*;
import com.java.machine_test.Services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import com.java.machine_test.Entity.Product;

import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public Page<Product> getAllProducts(@RequestParam(defaultValue = "0") int page,
                                        @RequestParam(defaultValue = "20") int size) {
        return productService.getAllProducts(PageRequest.of(page, size));
    }

    @GetMapping("/getProductById")
    public Optional<Product> getProductById(@PathVariable Integer id) {
        return productService.getProductById(id);
    }

    @PostMapping("/createProduct")
    public Product createProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }
    
    @DeleteMapping("/deleteProduct")
    public void deleteProduct(@PathVariable Integer id) {
        productService.deleteProduct(id);
    }

    @PutMapping("/updateProduct")
    public Product updateProduct(@PathVariable Integer id, @RequestBody Product product) {
        product.setId(id);
        return productService.saveProduct(product);
    }

}