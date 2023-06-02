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
    private Integer idProducto;

    @Column(name = "nombre")
    private String productNombre;

    @Column(name ="id_categoria")
    private Integer idCategoria;

    @Column(name ="codigo_barras")
    private String codigoBarras;

    @Column(name ="precio_venta")
    private Double precioVenta;

    @Column(name ="cantidad_stock")
    private Integer cantidadStock;

    private Boolean estado;

    @ManyToOne
    @JoinColumn(name = "id_categoria", insertable = false, updatable = false)
   private Category categoria;

   @OneToMany(mappedBy = "producto")
    private List<ComprasProducto> comprasProducto;


    //Get and set


    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProduct() {
        return productNombre;
    }

    public void setNombreProduct(String nombreProduct) {
        this.productNombre = nombreProduct;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Integer getCantidadStock() {
        return cantidadStock;
    }

    public void setCantidadStock(Integer cantidadStock) {
        this.cantidadStock = cantidadStock;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}