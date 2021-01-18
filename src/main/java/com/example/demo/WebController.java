package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class WebController
{
	@Autowired
	CustomerDao repository;

	@Autowired
	UserDao userDao;

	@GetMapping(path = "/", produces = {"application/json"})
	public List<CustomerE> findAll()
	{
		return repository.getData();
	}

	@GetMapping(path = "/user", produces = {"application/json"})
	public List<User> getuser()
	{
		List<User> aa = new ArrayList<>();
		userDao.findAll().forEach(data -> aa.add(data));
		return aa;
	}


	@PostMapping(path= "/", consumes = "application/json", produces = "application/json")
	public ResponseEntity<CustomerE> addCustomer(
			@RequestBody CustomerE customer)
			throws Exception
	{
		repository.save(customer);
		return new ResponseEntity<CustomerE>(customer, HttpStatus.CREATED);
	}

}
