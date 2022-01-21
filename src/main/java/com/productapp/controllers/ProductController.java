package com.productapp.controllers;

import com.productapp.model.CategoryView;
import com.productapp.model.Product;
import com.productapp.model.TypeView;
import com.productapp.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product-api")
@CrossOrigin("http://localhost:4200")
public class ProductController {
    IProductService productService;

    @Autowired
    public void setProductService(IProductService productService) {
        this.productService = productService;
    }


    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @PutMapping("/products")
    public void updateProduct(@RequestBody Product product) {
        productService.updateProduct(product);
    }

    @DeleteMapping("products/id/{id}")
    void deleteProduct(@PathVariable("id") int productId) {
        productService.deleteProduct(productId);
    }

    @GetMapping("/products")
    public List<Product> getAll() {
        return productService.getAll();
    }

    @GetMapping("/products/brand/{brand}")
    public List<Product> getByBrand(@PathVariable("brand") String brand) {
        return productService.getByBrand(brand);
    }

    @GetMapping("/products/category/{category}")
    public List<Product> getByCategory(@PathVariable("category") String category) {
        return productService.getByCategory(category);
    }

    @GetMapping("/products/type/{type}")
    public List<Product> getByType(@PathVariable("type") String type) {
        return productService.getByType(type);
    }

    @GetMapping("/products/id/{productId}")
    public Product getById(@PathVariable("productId") int productId) {
        return productService.getById(productId);
    }


    @GetMapping("/products/categorytype/{category}")
    public List<TypeView> getTypeByCategory(@PathVariable("category") String category) {
        return productService.getTypeByCategory(category);
    }

    @GetMapping("/products/category/distinct")
    public List<String> getDistinct() {
        return productService.getDistinctByCategory();
    }
}