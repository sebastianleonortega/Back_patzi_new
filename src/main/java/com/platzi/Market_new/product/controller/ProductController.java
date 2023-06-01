package com.platzi.Market_new.product.controller;

import com.platzi.Market_new.product.dto.ProductDto;
import com.platzi.Market_new.product.service.ProductServiceImple;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductServiceImple productServiceImple;

    @GetMapping("/all")
    public ResponseEntity<List<ProductDto>>  getAll(){
        return new ResponseEntity<>(productServiceImple.getAllProduct(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProduct(@PathVariable("id") int idProducto ){
        return productServiceImple.getProductId(idProducto).map(productDto -> new ResponseEntity<>(productDto, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/byCategory/{idCategoria}")
    public  ResponseEntity<List<ProductDto>> getProductByCategory(@PathVariable("idCategoria") int idCategoria){
        List<ProductDto > productDtos = productServiceImple.getProductByCategory(idCategoria);
        if (productDtos.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(productDtos, HttpStatus.OK);
    }

    @PostMapping("/save/")
    public ResponseEntity<ProductDto> save (@Valid @RequestBody ProductDto productDto, BindingResult result){
        if (result.hasErrors()){
            throw new IllegalArgumentException("error al crear el producto");
        }
        return new ResponseEntity<>(productServiceImple.saveProduct(productDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
   public ResponseEntity<ProductDto> updateProduct (@RequestBody ProductDto productDto, @PathVariable("Id") Integer idProducto, BindingResult result){
        if (result.hasErrors()){
            throw new IllegalArgumentException("error al actualizar el producto");
        }
        return new ResponseEntity<>(productServiceImple.updateProduct(idProducto, productDto), HttpStatus.OK);
   }
}
