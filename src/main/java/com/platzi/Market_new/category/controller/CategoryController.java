package com.platzi.Market_new.category.controller;

import com.platzi.Market_new.category.dto.CategoryDto;
import com.platzi.Market_new.category.service.CategoryService;
import com.platzi.Market_new.category.service.CategoryServiceImple;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/all")
    public ResponseEntity<List<CategoryDto>> findAll(){
        List<CategoryDto> categoryDtos = categoryService.getAllCategory();
        if (!categoryDtos.isEmpty()){
            return new ResponseEntity<>(categoryDtos, HttpStatus.OK);
        }
       return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable("id") int idCategory){
        return categoryService.getCategoryId(idCategory).map(categoryDto -> new ResponseEntity<>(categoryDto, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save/")
    public ResponseEntity<CategoryDto> save (@Valid @RequestBody CategoryDto categoryDto, BindingResult result){
        if (result.hasErrors()){
            throw new IllegalArgumentException("ERROR AL CREAR EL PRODUCTO");
        }
        return new ResponseEntity<>(categoryService.saveCategory(categoryDto), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public  ResponseEntity<CategoryDto> updateCategory (@RequestBody CategoryDto categoryDto, @PathVariable("id") Integer idCategory, BindingResult result){
        if (result.hasErrors()){
            throw  new IllegalArgumentException("Error al actualizar el producto");
        }
        return new ResponseEntity<>(categoryService.updateCategory(idCategory, categoryDto), HttpStatus.OK);
    }
}
