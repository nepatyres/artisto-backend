package com.code.artisto.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private int stock;
    @ElementCollection
    private List<String> images;
    private Boolean available;

    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private Bestseller bestseller;

    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private MoreProducts moreProducts;

    public Product(String name, String description, BigDecimal price, int stock,List<String> images ,Boolean available) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.images = images;
        this.available = available;
    }
}
