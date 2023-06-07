package com.platzi.Market_new.product.entity;

import com.platzi.Market_new.category.entity.Category;
import com.platzi.Market_new.purchase_product.entity.ComprasProducto;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "productos")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Integer idProduct;

    @Column(name = "nombre")
    private String productName;

    @Column(name ="id_categoria")
    private Integer idCategory;

    @Column(name ="codigo_barras")
    private String barCode;

    @Column(name ="precio_venta")
    private Double priceSale;

    @Column(name ="cantidad_stock")
    private Integer quantityStock;

    @Column(name = "estado")
    private Boolean state;

    @ManyToOne
    @JoinColumn(name = "id_categoria", insertable = false, updatable = false)
   private Category category;

   @OneToMany(mappedBy = "producto")
    private List<ComprasProducto> purchasesProduct;


    //Get and set


    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Integer idCategory) {
        this.idCategory = idCategory;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public Double getPriceSale() {
        return priceSale;
    }

    public void setPriceSale(Double priceSale) {
        this.priceSale = priceSale;
    }

    public Integer getQuantityStock() {
        return quantityStock;
    }

    public void setQuantityStock(Integer quantityStock) {
        this.quantityStock = quantityStock;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<ComprasProducto> getPurchasesProduct() {
        return purchasesProduct;
    }

    public void setPurchasesProduct(List<ComprasProducto> purchasesProduct) {
        this.purchasesProduct = purchasesProduct;
    }
}
