package com.platzi.Market_new.purchase_product.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.UUID;

@Embeddable
public class ComprasProductoPK implements Serializable {

    @Column(name= " id_compra")
    private Integer idCompra;

    @Column(name = "id_producto")
    private Integer idProducto;


    //GET AND SET

    public Integer getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Integer idCompra) {
        this.idCompra = idCompra;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }
}
