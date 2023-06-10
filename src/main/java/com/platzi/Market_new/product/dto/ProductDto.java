package com.platzi.Market_new.product.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.antlr.v4.runtime.misc.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDto {

    @JsonProperty(value = "idProduct", access = JsonProperty.Access.READ_ONLY)
    private Integer idProduct;

    @JsonProperty(value= "productName")
    private String productName;

    @JsonProperty(value="idCategory")
    private Integer idCategory;

    @JsonProperty(value = "barCode")
    private String barCode;

    @JsonProperty(value = "priceSale")
    private double priceSale;

    @JsonProperty(value = "quantityStock")
    private Integer quantityStock;

    @JsonProperty(value = "state")
    private boolean state;


//GET AND SET


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

    public double getPriceSale() {
        return priceSale;
    }

    public void setPriceSale(double priceSale) {
        this.priceSale = priceSale;
    }

    public Integer getQuantityStock() {
        return quantityStock;
    }

    public void setQuantityStock(Integer quantityStock) {
        this.quantityStock = quantityStock;
    }

    public boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}
