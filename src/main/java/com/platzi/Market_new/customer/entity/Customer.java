package com.platzi.Market_new.customer.entity;

import com.platzi.Market_new.purchase.entity.Purchase;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "clientes")
public class Customer {

    @Id
    @Column(name ="id")
    private Integer customerId;

    @Column(name ="nombre")
    private String name;

    @Column(name="apellidos")
    private String lastName;

    @Column(name = "celular")
    private double phone;

    @Column(name = "direccion")
    private String address;

    @Column(name = "correo_electronico")
    private String email;

    @OneToMany(mappedBy = "customer")
    private List<Purchase> purchases;


    //GET AND SET


    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getPhone() {
        return phone;
    }

    public void setPhone(double phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Purchase> getCompras() {
        return purchases;
    }

    public void setCompras(List<Purchase> compras) {
        this.purchases = compras;
    }
}
