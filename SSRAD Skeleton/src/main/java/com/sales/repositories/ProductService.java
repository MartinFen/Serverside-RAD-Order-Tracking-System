package com.sales.repositories;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.models.Product;


@Service
public class ProductService {
	
	@Autowired
	private ProductInterface productInterface;
	
	public ArrayList<Product> getAll() {

		return (ArrayList<Product>) productInterface.findAll();
	}

}
