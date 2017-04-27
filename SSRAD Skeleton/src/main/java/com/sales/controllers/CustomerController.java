package com.sales.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
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

@Controller
public class CustomerController {

	/*
	 * @Autowired private OrderService os;
	 * 
	 * @RequestMapping(value = "/showCustomers", method = RequestMethod.GET)
	 * public String getCustomers(Model m) {
	 * 
	 * ArrayList<Order> orders = os.getAll();
	 * 
	 * for (Order o1 : orders) { System.out.println("Orderid=" + o1.getoId());
	 * System.out.println("Orderid=" + o1.getCust().getcName()); }
	 * 
	 * m.addAttribute("orders", orders);
	 * 
	 * return "displayCustomer"; }
	 */

	@Autowired
	private CustomerService cs;

	@RequestMapping(value = "/addCustomer", method = RequestMethod.GET)
	public String getProduct(@ModelAttribute("customer1") Customer c, HttpServletRequest h) {
		System.out.println("HTTP Request = " + h.getMethod());
		return "addCustomer";
	}

	@RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
	public String postProduct(@Valid @ModelAttribute("customer1") Customer c, BindingResult result,
			HttpServletRequest h, Model m) {

		if (result.hasErrors()) {

			return "addCustomer";

		} else {
			System.out.println("HTTP Request = " + h.getMethod());

			cs.save(c);

			ArrayList<Customer> customers = cs.getAll();

			for (Customer c1 : customers) {
				System.out.println("Cid=" + c1.getcId());
				for (Order o1 : c1.getOrders()) {
					System.out.println("Oid=" + o1.getoId());
				}
			}

			m.addAttribute("customers", customers);

			return "displayCustomer";
		}
	}

	@RequestMapping(value = "/showCustomers", method = RequestMethod.GET)
	public String getCustomers(Model m) {

		ArrayList<Customer> customers = cs.getAll();

		for (Customer c1 : customers) {
			System.out.println("Cid=" + c1.getcId());
			for (Order o1 : c1.getOrders()) {
				System.out.println("Oid=" + o1.getoId());
			}
			// System.out.println("Orderid=" + c1.getCust().getcName());
		}

		m.addAttribute("customers", customers);

		return "displayCustomer";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/login?logout";
	}
}
