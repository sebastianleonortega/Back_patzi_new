package com.platzi.Market_new.product.repository;

import com.platzi.Market_new.product.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductoCrudRepository extends JpaRepository <Producto, Integer> {


    List<Producto> findByIdCategoria(Integer idCategoria);

    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);
}
