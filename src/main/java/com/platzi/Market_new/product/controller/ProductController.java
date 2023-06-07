package com.platzi.Market_new.product.controller;

import com.platzi.Market_new.product.dto.ProductDto;
import com.platzi.Market_new.product.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public ResponseEntity<List<ProductDto>>  getAll(){
        return new ResponseEntity<>(productService.getAllProduct(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProduct(@PathVariable("id") int idProduct ){
        return productService.getProductId(idProduct).map(productDto -> new ResponseEntity<>(productDto, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/byCategory/{id}")
    public  ResponseEntity<List<ProductDto>> getProductByCategory(@PathVariable("id") int idCategory){
        List<ProductDto > productDto = productService.getProductByCategory(idCategory);
        if (productDto.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(productDto, HttpStatus.OK);
    }

    @PostMapping("/save/")
    public ResponseEntity<ProductDto> save (@Valid @RequestBody ProductDto productDto, BindingResult result){
        if (result.hasErrors()){
            throw new IllegalArgumentException("error al crear el producto");
        }
        return new ResponseEntity<>(productService.saveProduct(productDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
   public ResponseEntity<ProductDto> updateProduct (@RequestBody ProductDto productDto, @PathVariable("id") Integer idProduct, BindingResult result){
        if (result.hasErrors()){
            throw new IllegalArgumentException("error al actualizar el producto");
        }
        return new ResponseEntity<>(productService.updateProduct(idProduct, productDto), HttpStatus.OK);
   }

   @DeleteMapping("/deleteproduct/{id}")
   public ResponseEntity<ProductDto> deleteProduct (@PathVariable("id") Integer idProduct){
        if (productService.deleteProduct(idProduct)){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
   }

}
