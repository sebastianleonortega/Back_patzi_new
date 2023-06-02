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
    private Integer idCategoria;


    private String descripcion;

    private Boolean estado;

    //-----------------------------------------------


    @OneToMany(mappedBy = "categoria")
    private List<Product> productos;


    //GET AND SET


    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
