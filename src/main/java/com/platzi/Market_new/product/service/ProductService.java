package com.platzi.Market_new.product.service;

import com.platzi.Market_new.product.dto.ProductDto;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<ProductDto> getAllProduct();
    Optional<ProductDto> getProductId(Integer idProducto);

    ProductDto saveProduct(ProductDto productDto);
    ProductDto updateProduct(Integer idProducto, ProductDto productDto);

    Boolean deleteProduct(Integer idProducto);

    Boolean existProductByName(String nombre);
}
