package com.code.artisto.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AddProductRequest{
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private int stock;
    private Boolean available;
}
