package com.sales.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sales.models.Product;
import com.sales.repositories.ProductInterface;


@Service
public class ProductService {
	
	@Autowired
	private ProductInterface productInterface;
	
	//add a product
	public Product save(Product product) {
		
		return productInterface.save(product);
	}
	
	//Retrive all products
	public ArrayList<Product> getAll() {

		return (ArrayList<Product>) productInterface.findAll();
	}

}
