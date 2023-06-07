package com.platzi.Market_new.customer.controller;

import com.platzi.Market_new.customer.dto.CustomerDto;
import com.platzi.Market_new.customer.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/all")
    public ResponseEntity<List<CustomerDto>> getAllCustomer( ) {
        return new ResponseEntity<>(customerService.getAllCustomer(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> findById(@PathVariable("id")  Integer customerId){
    return customerService.getCustomerById(customerId).map(customerDto ->
        new ResponseEntity<>(customerDto, HttpStatus.OK)
    ).orElse(null);
    }

    @PostMapping("/save/")
    public ResponseEntity<CustomerDto> save(@Valid @RequestBody CustomerDto customerDto, BindingResult result) throws IllegalArgumentException {
        if (result.hasErrors()){
            throw new IllegalArgumentException("Error al crear empleado ");
        }
        return new ResponseEntity<>(customerService.saveCustomer(customerDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDto> updateCustomer (@PathVariable("id") Integer customerId, @RequestBody CustomerDto customerDto,  BindingResult result){
        if (result.hasErrors()){
             throw  new IllegalArgumentException("Producto no actualizado");
        }
        return new ResponseEntity<>(customerService.updateCustomer(customerDto, customerId), HttpStatus.OK);
    }



}
