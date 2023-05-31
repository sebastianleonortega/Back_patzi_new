package com.platzi.Market_new.product.controller;

import com.platzi.Market_new.product.dto.ProductDto;
import com.platzi.Market_new.product.entity.Producto;
import com.platzi.Market_new.product.service.ProductServiceImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductServiceImple productServiceImple;

    @GetMapping("/all")
    public List<ProductDto> getAll(){
        return productServiceImple.getAllProduct();
    }

    @GetMapping("/{id}")
    public Optional<ProductDto> getProduct(@PathVariable("id") int idProducto ){
        return productServiceImple.getProductId(idProducto);
    }


}
