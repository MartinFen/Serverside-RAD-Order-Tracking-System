package com.sales.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.sales.models.Product;
import com.sales.repositories.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService ps;
	
	@RequestMapping(value = "/showProducts", method = RequestMethod.GET)
	public String getCustomers(Model m) {

		ArrayList<Product> products = ps.getAll();

		for (Product p1 : products) {
			System.out.println("name=" + p1.getpId());
		}

		m.addAttribute("products", products);

		return "displayProduct";
	}

}
