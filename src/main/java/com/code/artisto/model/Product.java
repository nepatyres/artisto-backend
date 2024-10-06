package com.code.artisto.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
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

    @OneToMany(mappedBy = "products", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Image> images;

    private Bestseller bestseller;
    private MoreProducts moreProducts;
}
