package com.platzi.Market_new.product.repository;

import com.platzi.Market_new.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository <Product, Integer> {



    List<Product> findByIdCategory(Integer idCategory);

    Boolean existsByProductName (String productName);

    @Query(value = "SELECT * FROM public.productos WHERE id_producto=?1", nativeQuery = true)
    Optional<Product> getProductoId(Integer idProduct);
}
