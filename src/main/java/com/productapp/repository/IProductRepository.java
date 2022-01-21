package com.productapp.repository;

import com.productapp.model.CategoryView;
import com.productapp.model.Product;
import com.productapp.model.TypeView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findByCategory(String category);

    List<Product> findByBrand(String brand);

    List<Product> findByType(String type);

    //    @Query("select distinct type from Product p where p.category=?1")
    List<TypeView> findDistinctTypeByCategory(String category);

    //    Product findById(int id);
    @Query("select distinct category from Product")
    List<String> findDistinctByCategory();
}
