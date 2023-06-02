package com.platzi.Market_new.category.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CategoryDto {

    @JsonProperty(value ="idCategoria", access = JsonProperty.Access.READ_ONLY)
    private Integer idCategoria;

    @JsonProperty(value = "descripcion")
    private String descripcion;

    @JsonProperty(value = "estado")
    private Boolean estado;

    //GET AN SET


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
