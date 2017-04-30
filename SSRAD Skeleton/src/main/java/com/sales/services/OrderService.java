package com.sales.services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sales.exceptions.*;
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

	public Order save(Order o)
			throws NullCIdException, NullPIdException, NotCIdException, NotPIdException, QtyException {

		c = customerInterface.findOne(o.getCust().getcId());
		p = productInterface.findOne(o.getProd().getpId());

		if (c == null) {
			throw new NullCIdException("No Customer Id entered");
		} else if (p == null) {
			throw new NullPIdException("No Product Id entered");
		} else if (o.getCust().getcId() != c.getcId()) {
			throw new NotCIdException("Customer Id doestnt exist: " + c.getcId());
		} else if (o.getProd().getpId() != p.getpId()) {
			throw new NotPIdException("Product Id doestnt exist: " + p.getpId());
		} else if (o.getQty() > p.getQtyInStock()) {
			throw new QtyException("Not enough stock ");
		} else {

			p.setQtyInStock(p.getQtyInStock() - o.getQty());

			o.setOrderDate(dateFormat.format(date));

			o.getCust().setcName(c.getcName());

			o.getProd().setpDesc(p.getpDesc());

			orderInterface.save(o);

			return orderInterface.save(o);
		}
	}
}
