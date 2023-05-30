package com.platzi.Market_new.product.repository;

import com.platzi.Market_new.product.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository <Producto, Integer> {


    List<Producto> findByIdCategoria(Integer idCategoria);

    Boolean existProductByName(String nombre);

    @Query(value = "SELECT * FROM public.productos WHERE id_producto=?1", nativeQuery = true)
    Optional<Producto> getProductoId(Integer idProducto);
}
