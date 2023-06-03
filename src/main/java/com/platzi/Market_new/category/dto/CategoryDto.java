package com.platzi.Market_new.category.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CategoryDto {

    @JsonProperty(value ="idCategory", access = JsonProperty.Access.READ_ONLY)
    private Integer idCategory;

    @JsonProperty(value = "description")
    private String description;

    @JsonProperty(value = "state")
    private Boolean state;


    //GET AN SET


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
}
