package com.productapp.model;


import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor

public class Product {
    @Column(name = "productid")
    @Id
    @GeneratedValue(generator = "product-seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "product-seq", sequenceName = "product_seq", initialValue = 1, allocationSize = 1)
    private Integer productId;
    private String name;
    private double price;
    private String category;
    private String brand;
    private double rating;
    private String description;
    @Column(name = "productimg")
    private String productImg;
    private String type;


    public Product(String name, double price, String category, String brand, double rating, String description, String productImg, String type) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.brand = brand;
        this.rating = rating;
        this.description = description;
        this.productImg = productImg;
        this.type = type;
    }
}
