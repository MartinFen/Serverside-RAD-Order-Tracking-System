package com.sales.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sales.models.Customer;
import com.sales.models.Order;
import com.sales.models.Product;
import com.sales.services.CustomerService;
import com.sales.services.OrderService;
import com.sales.services.ProductService;

@Controller
public class OrderController {

	@Autowired
	private OrderService os;
	
	@Autowired
	private ProductService ps;
	
	@Autowired
	private CustomerService cs;

	@RequestMapping(value = "/showOrders", method = RequestMethod.GET)
	public String showCust(Model m) {

		ArrayList<Order> orders = os.getAll();
		//ArrayList<Customer> customers = cs.getAll();

		for (Order o1 : orders) {
			System.out.println("Orderid=" + o1.getoId());
			
		}
		
		/*for (Order o1 : orders) {
			System.out.println("Orderid=" + o1.getoId());
			for (int i=0; i >= orders.size(); i++) 
			{
				if(i == 1)
					
				System.out.println("Oid=" + orders.get(i));
			}
		}*/

		m.addAttribute("orders", orders);

		return "displayOrder";
	}
	
	@RequestMapping(value = "/addOrder", method=RequestMethod.GET)
	public String getOrder(@ModelAttribute("order1") Order o, HttpServletRequest h)
	{
		System.out.println("HTTP Request = " + h.getMethod());
			return "addOrder";
	}
	
	@RequestMapping(value = "/addOrder", method=RequestMethod.POST)
	public String postOrder(@Valid @ModelAttribute("order1") Order o, BindingResult result, HttpServletRequest h, Model m) {
		
		if (result.hasErrors()) {
			
			return "addOrder";
		
		} else {
		
			System.out.println("HTTP Request = " + h.getMethod());
		
		os.save(o);
		
		ArrayList<Order> orders = os.getAll();
		
		for (Order o1 : orders) {
			System.out.println("Orderid=" + o1.getoId());
		}

		m.addAttribute("orders", orders);

		return "displayOrder";
		} 
	}

}
