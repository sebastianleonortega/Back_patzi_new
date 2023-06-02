package com.platzi.Market_new.category.controller;

import com.platzi.Market_new.category.dto.CategoryDto;
import com.platzi.Market_new.category.service.CategoryServiceImple;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private CategoryServiceImple categoryServiceImple;

    @GetMapping("/all")
    public ResponseEntity<List<CategoryDto>> getAll(){
        return new ResponseEntity<>(categoryServiceImple.getAllCategory(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable("id") int idCategoria){
        return categoryServiceImple.getCategoryId(idCategoria).map(categoryDto -> new ResponseEntity<>(categoryDto, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save/")
    public ResponseEntity<CategoryDto> save (@Valid @RequestBody CategoryDto categoryDto, BindingResult result){
        if (result.hasErrors()){
            throw new IllegalArgumentException("ERROR AL CREAR EL PRODUCTO");
        }
        return new ResponseEntity<>(categoryServiceImple.saveCategory(categoryDto), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public  ResponseEntity<CategoryDto> updateCategory (@RequestBody CategoryDto categoryDto, @PathVariable("id") Integer idCategoria, BindingResult result){
        if (result.hasErrors()){
            throw  new IllegalArgumentException("Error al actualizar el producto");
        }
        return new ResponseEntity<>(categoryServiceImple.updateCategory(idCategoria, categoryDto), HttpStatus.OK);
    }
}
