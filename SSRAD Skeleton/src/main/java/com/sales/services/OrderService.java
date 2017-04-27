package com.sales.services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.exceptions.NotFoundException;
import com.sales.models.*;
import com.sales.repositories.*;

@Service
public class OrderService {

	@Autowired
	private OrderInterface orderInterface;
	
	@Autowired
	private ProductInterface productInterface;
	
	@Autowired
	private CustomerInterface customerInterface;

	private Customer c;
	private Product p;
	
	private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	private Date date = new Date();

	public ArrayList<Order> getAll() {

		return (ArrayList<Order>) orderInterface.findAll();
		//return 
	}

	public Order save(Order o) throws NotFoundException {

		c = customerInterface.findOne(o.getCust().getcId());
		p = productInterface.findOne(o.getProd().getpId());
		
		if (c == null || p == null) 
		{
			throw new NotFoundException("Empty!");
		} 
		else 
		{
			p.setQtyInStock(p.getQtyInStock() - o.getQty());
			
			o.setOrderDate(dateFormat.format(date));
			
			o.getCust().setcName(c.getcName());
			
			o.getProd().setpDesc(p.getpDesc());
			
			orderInterface.save(o);
			
			return orderInterface.save(o);
		}
	}
}
