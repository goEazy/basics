package com.goeazy.learn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.goeazy.learn.context.Application;
import com.goeazy.learn.entity.Customer;

@Repository
public class CustomersDaoImpl implements CustomersDao {

	private static final String TABLE_NAME="CUSTOMERS";


	public void save(Customer customer) throws SQLException{
		String query = "insert into " + TABLE_NAME + " (cust_id, first_name, last_name, city, salesman_id) values (?,?,?,?,?)";
		Connection con = null;
		JdbcTemplate jdbcTemplate = Application.getInstance().getJdbcTemplate();
		DataSource dataSource = Application.getInstance().getDataSource();
		PreparedStatement ps = null;
		
		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			ps.setInt(1, customer.getCustId());
			ps.setString(2, customer.getFirstName());
			ps.setString(3, customer.getLastName());
			ps.setString(4, customer.getCity());
			ps.setInt(5, customer.getSalesmanId());
			int out = ps.executeUpdate();
			if (out != 0) {
				System.out.println("Customer saved with id=" + customer.getCustId());
			} else
				System.out.println("Customer save failed with id=" + customer.getCustId());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public Customer getByCustId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void update(Customer customer) {
		// TODO Auto-generated method stub

	}

	public void deleteById(int id) {
		// TODO Auto-generated method stub

	}

	public List<Customer> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
