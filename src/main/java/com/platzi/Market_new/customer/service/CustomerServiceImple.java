package com.platzi.Market_new.customer.service;

import com.platzi.Market_new.customer.dto.CustomerDto;
import com.platzi.Market_new.customer.entity.Customer;
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
            return modelMapper.map(customer, CustomerDto.class);
        }).collect(Collectors.toList());
    }

    @Override
    public Optional<CustomerDto> getCustomerById(Integer customerId) {
        return Optional.ofNullable(customerRepository.findById(customerId).map(customer -> {
            return modelMapper.map(customer, CustomerDto.class);
        }).orElseThrow(()-> new IllegalArgumentException("El cliente no existe")));
    }

    @Override
    public CustomerDto saveCustomer(CustomerDto customerDto) {
        if (customerRepository.findById(customerDto.getCustomerId()).isPresent()){
            throw  new IllegalArgumentException("Ya existe un cliente con esta identificacion ");
        }try {
            return modelMapper.map(customerRepository.save(modelMapper.map(customerDto, Customer.class)), CustomerDto.class);
        }catch (Exception ex){
            throw new IllegalArgumentException("json mal estructurados");
        }
    }

    @Override
    public CustomerDto updateCustomer(CustomerDto customerDto, Integer customerId) {
        return customerRepository.findById(customerId).map(customer -> {
            customer.setName((customerDto.getName()!=null)?customerDto.getName(): customer.getName());
            customer.setLastName((customerDto.getLastName()!=null)?customerDto.getLastName(): customer.getLastName());
            customer.setPhone((customerDto.getPhone()!=null)?customerDto.getPhone(): customer.getPhone());
            customer.setAddress((customerDto.getAddress()!=null)?customerDto.getAddress(): customer.getAddress());
            customer.setEmail((customerDto.getEmail()!=null)?customerDto.getEmail():customer.getEmail());
            return modelMapper.map(customerRepository.save(customer),CustomerDto.class);
        }).orElseThrow(()-> new IllegalArgumentException("No se econtro el cliente parta actualizar"));
    }

}
