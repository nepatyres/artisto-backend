package com.code.artisto.service.moreProducts;


import com.code.artisto.exceptions.ProductNotFoundException;
import com.code.artisto.model.MoreProducts;
import com.code.artisto.repository.MoreProductsRepository;
import com.code.artisto.repository.ProductRepository;
import com.code.artisto.request.AddProductRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MoreProductsService implements IMoreProductsService {
    private final ProductRepository productRepository;
    private final MoreProductsRepository moreProductsRepository;

    @Override
    public MoreProducts addMoreProducts(AddProductRequest request){
        return null;
    }

    @Override
    public MoreProducts getMoreProductsById(Long id){
        return moreProductsRepository.findById(id)
                .orElseThrow(()-> new ProductNotFoundException("product not found"));
    }

    @Override
    public void deleteMoreProducts(Long id){
        moreProductsRepository.findById(id)
                .ifPresentOrElse(moreProductsRepository:: delete,
                ()->{throw new ProductNotFoundException("product not found");});
    }

    @Override
    public void updateMoreProducts(MoreProducts moreProducts, Long moreProductsId){

    }
}
