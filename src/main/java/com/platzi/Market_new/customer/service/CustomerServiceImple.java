package com.platzi.Market_new.customer.service;

import com.platzi.Market_new.customer.dto.CustomerDto;
import com.platzi.Market_new.customer.repository.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImple implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<CustomerDto> getAllCustomer() {
        return customerRepository.findAll().stream().map(customer -> {
            return modelMapper.map(customer, CustomerDto.class),
        }).collect(Collectors.toList());
    }

    @Override
    public Optional<CustomerDto> getCustomerById(Integer customerId) {
        return Optional.ofNullable(customerRepository.getCustomersBy(customerId).map(customer -> {
            return modelMapper.map(customer, CustomerDto.class);
        }).orElseThrow(()-> new IllegalArgumentException("El cliente no existe")));
    }

    @Override
    public CustomerDto saveCustomer(CustomerDto customerDto) {
        if (getCustomerById(customerDto.getCustomerId()){
            return new IllegalArgumentException("Ya existe un cliente con este nombre y apellido")
        }
        return modelMapper.map(customerRepository.save(modelMapper.map(customerDto, CustomerDto.class)), CustomerDto.class);
    }

    @Override
    public CustomerDto updateCustomer(CustomerDto customerDto, Integer customerId) {
        return null;
    }

}
