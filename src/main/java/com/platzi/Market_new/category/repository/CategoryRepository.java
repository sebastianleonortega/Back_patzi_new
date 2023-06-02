package com.platzi.Market_new.category.repository;

import com.platzi.Market_new.category.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    @Query(value ="Select * from public.categorias where id_categoria=?1", nativeQuery = true)
    Optional<Category> getCategoryId(Integer idCategoria);

    Boolean existsByCategoryDescrition (String descripcion);
}
