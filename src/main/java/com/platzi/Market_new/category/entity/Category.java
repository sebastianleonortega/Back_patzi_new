package com.platzi.Market_new.category.entity;
import com.platzi.Market_new.product.entity.Product;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "categorias")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Integer idCategory;

    @Column(name ="descripcion")
    private String description;

    @Column(name= "estado")
    private Boolean state;

    //-----------------------------------------------


    @OneToMany(mappedBy = "category")
    private List<Product> productos;


    //GET AND SET


    public Integer getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Integer idCategory) {
        this.idCategory = idCategory;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public List<Product> getProductos() {
        return productos;
    }

    public void setProductos(List<Product> productos) {
        this.productos = productos;
    }
}
