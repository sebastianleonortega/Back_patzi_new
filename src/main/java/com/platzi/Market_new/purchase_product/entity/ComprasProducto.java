package com.platzi.Market_new.purchase_product.entity;

import com.platzi.Market_new.product.entity.Product;
import com.platzi.Market_new.purchase.entity.Purchase;
import jakarta.persistence.*;

@Entity
@Table(name = "compras_productos")
public class ComprasProducto {

    @EmbeddedId
    private ComprasProductoPK id;

    @Column(name = "cantidad")
    private Integer quantity;

    private double total;

    @Column(name = "estado")
    private Boolean state;

    @ManyToOne
    @JoinColumn(name ="id_producto", insertable = false, updatable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "id_compra", updatable = false, insertable = false)
    private Purchase purchase;



    //GET AND SET

    public ComprasProductoPK getId() {
        return id;
    }

    public void setId(ComprasProductoPK id) {
        this.id = id;
    }


    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Purchase getCompra() {
        return purchase;
    }

    public void setCompra(Purchase purchase) {
        this.purchase = purchase;
    }
}
