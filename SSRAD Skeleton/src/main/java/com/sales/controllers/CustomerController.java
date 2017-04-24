package com.sales.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sales.models.Customer;
import com.sales.models.Order;
import com.sales.services.CustomerService;
import com.sales.services.OrderService;

@Controller
public class CustomerController {
	
	/*@Autowired
	private OrderService os;
	
	@RequestMapping(value = "/showCustomers", method = RequestMethod.GET)
	public String getCustomers(Model m) {

		ArrayList<Order> orders = os.getAll();

		for (Order o1 : orders) {
			System.out.println("Orderid=" + o1.getoId());
			System.out.println("Orderid=" + o1.getCust().getcName());
		}

		m.addAttribute("orders", orders);

		return "displayCustomer";
	}*/
	
	@Autowired
	private CustomerService cs;
	
	@RequestMapping(value = "/showCustomers", method = RequestMethod.GET)
	public String getCustomers(Model m) {

		ArrayList<Customer> customers = cs.getAll();

		for (Customer c1 : customers) {
			System.out.println("Cid=" + c1.getcId());
			for (Order o1: c1.getOrders()) {
				System.out.println("Oid=" + o1.getoId());
			}
			//System.out.println("Orderid=" + c1.getCust().getcName());
		}

		m.addAttribute("customers", customers);

		return "displayCustomer";
	}

}
