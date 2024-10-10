package com.code.artisto.service.product;

import com.code.artisto.exceptions.ProductNotFoundException;
import com.code.artisto.model.Product;
import com.code.artisto.repository.ProductRepository;
import com.code.artisto.request.AddProductRequest;
import com.code.artisto.request.UpdateProductRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService implements ProductInterface{
    private final ProductRepository productRepository;

    @Override
    public Product addProduct(AddProductRequest request) {
        return productRepository.save(createProduct(request));
    }

    private Product createProduct(AddProductRequest request){
        return new Product(
                request.getName(),
                request.getDescription(),
                request.getPrice(),
                request.getStock(),
                request.getAvailable()
        );
    };

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(()-> new ProductNotFoundException("product not found!"));
    }

    @Override
    public Product updateProduct(UpdateProductRequest request, Long productId) {
        return productRepository.findById(productId)
        .map(existingProduct -> updateExistingProduct(existingProduct, request))
        .map(productRepository :: save)
        .orElseThrow(() -> new ProductNotFoundException("product not found!"));
    }

    @Override
    public void deleteProductById(Long id) {
        productRepository.findById(id)
                .ifPresentOrElse(productRepository::delete,
                        ()->{throw new ProductNotFoundException("product not found!");});
    }

    private Product updateExistingProduct(Product existingProduct, UpdateProductRequest request){
        existingProduct.setName(request.getName());
        existingProduct.setDescription(request.getDescription());
        existingProduct.setPrice(request.getPrice());
        existingProduct.setStock(request.getStock());
        existingProduct.setAvailable(request.getAvailable());
        return existingProduct;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
