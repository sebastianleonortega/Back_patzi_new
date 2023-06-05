package com.platzi.Market_new.customer.service;

import com.platzi.Market_new.customer.dto.CustomerDto;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    List<CustomerDto> getAllCustomer();

    Optional<CustomerDto> getCustomerById(Integer customerId);

    CustomerDto saveCustomer(CustomerDto customerDto);

    CustomerDto updateCustomer(CustomerDto customerDto, Integer customerId);

}
