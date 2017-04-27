package com.sales.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sales.models.Customer;

@Repository
public interface CustomerInterface extends CrudRepository<Customer, Long> {

}
