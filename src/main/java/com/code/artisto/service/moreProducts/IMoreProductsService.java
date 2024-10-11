package com.code.artisto.service.moreProducts;

import com.code.artisto.model.MoreProducts;
import com.code.artisto.request.AddProductRequest;

public interface IMoreProductsService {
    MoreProducts addMoreProducts(AddProductRequest moreProducts);
    MoreProducts getMoreProductsById(Long id);
    void updateMoreProducts(MoreProducts moreProducts, Long moreProductsId);
    void deleteMoreProducts(Long id);
}
