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

import com.sales.models.Product;
import com.sales.services.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService ps;

	@RequestMapping(value = "/addProduct", method = RequestMethod.GET)
	public String getProduct(@ModelAttribute("product1") Product p, HttpServletRequest h) {
		System.out.println("HTTP Request = " + h.getMethod());
		return "addProduct";
	}

	@RequestMapping(value = "/addProduct", method = RequestMethod.POST)
	public String postProduct(@Valid @ModelAttribute("product1") Product p, BindingResult result, HttpServletRequest h,
			Model m) {

		if (result.hasErrors()) {
			
			return "addProduct";
		
		} else {

			System.out.println("HTTP Request = " + h.getMethod());

			//add to db
			ps.save(p);

			//get from db
			ArrayList<Product> products = ps.getAll();
			
			//testing if arraylist has values
			for (Product p1 : products) {
				System.out.println("name=" + p1.getpId());
			}
			
			//Add to model obj
			m.addAttribute("products", products);
			
			return "displayProduct";
		}
	}

	@RequestMapping(value = "/showProducts", method = RequestMethod.GET)
	public String showProduct(Model m) {

		ArrayList<Product> products = ps.getAll();

		for (Product p1 : products) {
			System.out.println("name=" + p1.getpId());
		}

		m.addAttribute("products", products);

		return "displayProduct";
	}
}
