package com.code.artisto.service.product;

import com.code.artisto.model.Product;
import com.code.artisto.request.AddProductRequest;
import com.code.artisto.request.UpdateProductRequest;

import java.util.List;

public interface IProductService {
    Product addProduct(AddProductRequest product);
    Product getProductById(Long id);
    Product updateProduct(UpdateProductRequest product, Long productId);
    void deleteProductById(Long id);
    List<Product> getAllProducts();

}
