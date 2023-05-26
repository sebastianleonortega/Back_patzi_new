package com.platzi.Market_new.category.entity;
import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "categorias")
public class Categotia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private UUID idCategoria;


    private String descripcion;

    private Boolean estado;



    //GET AND SET

    public UUID getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(UUID idCategoria) {
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
