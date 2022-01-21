package com.productapp.service;

import com.productapp.model.CategoryView;
import com.productapp.model.Product;
import com.productapp.model.TypeView;
import com.productapp.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductServiceImpl implements IProductService {

    private IProductRepository productRepository;

    @Autowired
    public void setProductRepository(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void updateProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public void deleteProduct(int productId) {
        productRepository.deleteById(productId);
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getByBrand(String brand) {
        return productRepository.findByBrand(brand);
    }

    @Override
    public List<Product> getByCategory(String category) {
        return productRepository.findByCategory(category);
    }

    @Override
    public List<TypeView> getTypeByCategory(String category) {
        return productRepository.findDistinctTypeByCategory(category);
    }

    @Override
    public List<String> getDistinctByCategory() {
        return productRepository.findDistinctByCategory();
    }

    @Override
    public Product getById(int productId) {
        return productRepository.findById(productId).get();
    }

    @Override
    public List<Product> getByType(String type) {
        return productRepository.findByType(type);
    }
}
