package com.productapp;

import com.productapp.model.CategoryView;
import com.productapp.model.Product;

import com.productapp.model.TypeView;
import com.productapp.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class ProductAppRestapiApplication implements CommandLineRunner {
    IProductService productService;

    @Autowired
    public void setProductService(IProductService productService) {
        this.productService = productService;
    }

    public static void main(String[] args) {
        SpringApplication.run(ProductAppRestapiApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        Product product = new Product();

        product.setName("128GB SSD");
        product.setPrice(2000);
        product.setBrand("WD");
        product.setCategory("Storage");
        product.setRating(4.2);
        product.setDescription("SSD with 128GB capacity");
        product.setProductImg("/assets/electronics/storage2.jpg");
        product.setType("SSD Drive");
//        productService.addProduct(product);
        List<TypeView> types = productService.getTypeByCategory("appliances");
        types.forEach(t -> System.out.println(t.getType()));

        List<String> categoryViews = productService.getDistinctByCategory();
        System.out.println(categoryViews);
//    }
    }
}