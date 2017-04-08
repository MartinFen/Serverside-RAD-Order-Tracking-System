package com.sales.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sales.models.Customer;
import com.sales.models.Product;
import com.sales.services.CustomerService;

@Controller
public class CustomerController {
	
	@Autowired
	private CustomerService cs;
	
	@RequestMapping(value = "/showCustomers", method = RequestMethod.GET)
	public String getCustomers(Model m) {

		ArrayList<Customer> customers = cs.getAll();

		for (Customer c1 : customers) {
			System.out.println("ID=" + c1.getcId());
		}

		m.addAttribute("customers", customers);

		return "displayCustomer";
	}

}
