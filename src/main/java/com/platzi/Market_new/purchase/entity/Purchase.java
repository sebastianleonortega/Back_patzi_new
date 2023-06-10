package com.platzi.Market_new.purchase.entity;

import com.platzi.Market_new.customer.entity.Customer;
import com.platzi.Market_new.purchase_product.entity.ComprasProducto;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "compras")
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_compra")
    private Integer purchaseId;

    @Column(name = "id_cliente")
    private Integer customerId;

    @Column(name = "fecha")
    private LocalDateTime date;

    @Column(name = "medio_pago")
    private String mediumPayment;

    @Column(name = "comentario")
    private String comment;

    @Column(name = "estado")
    private String state;

    @ManyToOne
    @JoinColumn(name = "id_cliente", updatable = false, insertable = false)
    private Customer customer;

    //-------------------------------------------
   @OneToMany(mappedBy = "purchase")
    private List<ComprasProducto> product;



    //GET AND SET


    public Integer getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Integer purchaseId) {
        this.purchaseId = purchaseId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public List<ComprasProducto> getProduct() {
        return product;
    }

    public void setProduct(List<ComprasProducto> product) {
        this.product = product;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getMediumPayment() {
        return mediumPayment;
    }

    public void setMediumPayment(String mediumPayment) {
        this.mediumPayment = mediumPayment;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<ComprasProducto> getProductos() {
        return product;
    }

    public void setProductos(List<ComprasProducto> productos) {
        this.product = productos;
    }
}
