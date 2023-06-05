package com.platzi.Market_new.customer.repository;

import com.platzi.Market_new.customer.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {


    @Query(value = "select * from public.clientes where id=?1", nativeQuery = true)
    Optional<Customer> getCustomersBy (Integer customerId);
}