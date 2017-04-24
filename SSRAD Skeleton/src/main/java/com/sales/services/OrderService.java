package com.sales.services;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sales.models.Order;
import com.sales.repositories.OrderInterface;

@Service
public class OrderService {
	
	@Autowired
	private OrderInterface orderInterface;
	
	public ArrayList<Order> getAll() {

		return (ArrayList<Order>) orderInterface.findAll();
	}

}
