package com.example.demo;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerDao
{
	List<CustomerE> customerList = new ArrayList<CustomerE>();

	@PostConstruct
	public void init(){
		customerList.add(new CustomerE(1, "frank"));
		customerList.add(new CustomerE(2, "john"));
	}
	public List<CustomerE> getData() {
		return customerList;
	}

	public void save(CustomerE customer) {
		customerList.add(customer);
	}
}
