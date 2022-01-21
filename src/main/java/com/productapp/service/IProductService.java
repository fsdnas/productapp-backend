package com.productapp.service;

import com.productapp.model.CategoryView;
import com.productapp.model.Product;
import com.productapp.model.TypeView;

import java.util.List;

public interface IProductService {
    Product addProduct(Product product);

    void updateProduct(Product product);

    void deleteProduct(int productId);

    List<Product> getAll();

    List<Product> getByBrand(String brand);

    List<Product> getByCategory(String category);

    List<TypeView> getTypeByCategory(String category);

    List<String> getDistinctByCategory();

    Product getById(int productId);

    List<Product> getByType(String type);

}
