package com.sales.services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sales.models.*;
import com.sales.repositories.*;

@Service
public class OrderService {

	@Autowired
	private OrderInterface orderInterface;

	@Autowired
	private CustomerInterface customerInterface;

	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
	Date date = new Date();

	public ArrayList<Order> getAll() {

		return (ArrayList<Order>) orderInterface.findAll();
	}

	public Order save(Order o) {
		// get date
		// System.out.println(dateFormat.format(date));

		o.setOrderDate(dateFormat.format(date));
		// o.getCust().getcId();
		// o.getProd().getpId();
		// check if cid exists -> customerInterface findBycid
		// check if pid exists
		// Catch exception
		//customerInterface.findById();
		//if(o.getCust().getcId()==customerInterface.findById(customer) )
		orderInterface.save(o);
		return orderInterface.save(o);
	}

	/*public Customer findById(Customer customer) {

		//return customer.getcId();
	}*/
}
