package com.goeazy.learn.dao;

import java.sql.SQLException;
import java.util.List;

import com.goeazy.learn.entity.Customer;

public interface CustomersDao {
		//Create
		public void save(Customer customer) throws SQLException;
		
		//Read
		public Customer getByCustId(int id);
		
		//Update
		public void update(Customer customer);
		
		//Delete
		public void deleteById(int id);
		
		//Get All
		public List<Customer> getAll();
}
