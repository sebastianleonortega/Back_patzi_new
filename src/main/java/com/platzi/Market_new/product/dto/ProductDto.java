package com.platzi.Market_new.product.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.antlr.v4.runtime.misc.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDto {

    @JsonProperty(value = "idProducto", access = JsonProperty.Access.READ_ONLY)
    private Integer idProducto;

    @JsonProperty(value= "nombre")
    private String productNombre;

    @JsonProperty(value="idCategoria")
    private Integer idCategoria;

    @JsonProperty(value = "codigoBarras")
    private String codigoBarras;

    @JsonProperty(value = " precioVenta")
    private double precioVenta;

    @JsonProperty(value = "cantidadStock")
    private Integer cantidadStock;

    @JsonProperty(value = "estado")
    private boolean estado;


//GET AND SET


    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getProductNombre() {
        return productNombre;
    }

    public void setProductNombre(String productNombre) {
        this.productNombre = productNombre;
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

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Integer getCantidadStock() {
        return cantidadStock;
    }

    public void setCantidadStock(Integer cantidadStock) {
        this.cantidadStock = cantidadStock;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
