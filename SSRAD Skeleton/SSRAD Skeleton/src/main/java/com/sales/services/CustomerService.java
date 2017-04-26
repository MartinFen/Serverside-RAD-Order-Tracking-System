package com.sales.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.models.Customer;
import com.sales.models.Product;
import com.sales.repositories.CustomerInterface;

@Service
public class CustomerService {

	@Autowired
	private CustomerInterface customerInterface;

	public ArrayList<Customer> getAll() {

		return (ArrayList<Customer>) customerInterface.findAll();
	}

	public Customer save(Customer customer) {

		return customerInterface.save(customer);
	}

	
}
