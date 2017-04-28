package com.sales.services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.exceptions.NotIdException;
import com.sales.exceptions.NullIdException;
import com.sales.exceptions.QtyException;
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
	}

	public Order save(Order o) throws NullIdException, NotIdException, QtyException {

		c = customerInterface.findOne(o.getCust().getcId());
		p = productInterface.findOne(o.getProd().getpId());
		
		if (c == null || p == null) 
		{
			throw new NullIdException("Id cannot be Empty!");
		}
		else if (o.getCust().getcId() != c.getcId() || o.getProd().getpId() != p.getpId()) 
		{
			throw new NotIdException("Id doestnt exist!");
		}
		else if(o.getQty() > p.getQtyInStock())
		{
			throw new QtyException("Not enough stock");
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
