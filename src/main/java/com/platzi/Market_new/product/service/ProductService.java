package com.platzi.Market_new.product.service;

import com.platzi.Market_new.product.dto.ProductDto;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<ProductDto> getAllProduct();
    Optional<ProductDto> getProductId(Integer idProduct);

    ProductDto saveProduct(ProductDto productDto);
    ProductDto updateProduct(Integer idProduct, ProductDto productDto);

    Boolean deleteProduct(Integer idProduct);

    Boolean existsByProductNombre (String productName);

    List<ProductDto> getProductByCategory(Integer idCategory);
}
