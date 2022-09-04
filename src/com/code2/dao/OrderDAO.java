package com.code2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import com.code2.modal.Order;
import com.code2.modal.OrderItem;
import com.code2.modal.Product;

public class OrderDAO {
	
	private DataSource dataSource;
	
	public OrderDAO(DataSource dataSource)
	{
		
		this.dataSource = dataSource;
	}
	public Order saveOrder(Order order) throws SQLException {
		
		Connection conn = dataSource.getConnection();
		String sql = "insert into orders (total,order_time,customer_name,mobile,address,deliveried) value(?,?,?,?,?,?)";
		PreparedStatement stmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		stmt.setDouble(1, order.getTotal());
		stmt.setTimestamp(2, order.getOrderTime());
		stmt.setString(3, order.getCustomerName());
		stmt.setString(4, order.getMobile());
		stmt.setString(5, order.getAddress());
		stmt.setBoolean(6, order.isDeliveried());
		int row = stmt.executeUpdate();
		if(row==1)
		{
			ResultSet result = stmt.getGeneratedKeys();
			if(result.next()) 
			{
			   int gendratedId =result.getInt(1);
			   order.setId(gendratedId);
			}
			
		}
		return order;
	}
	
	public List<Order> getOrders() throws SQLException{
		List<Order> orderList = new ArrayList<>();
		Connection conn = dataSource.getConnection();
		String sql = "select * from orders where deliveried=?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setBoolean(1,false);
		ResultSet result = stmt.executeQuery();
		while(result.next())
		{
		int id = result.getInt("id");
		 String customerName=result.getString("customer_name");
        Double total = result.getDouble("total");
        Timestamp orderTime=result.getTimestamp("order_time");
        String mobile = result.getString("mobile");
        String address = result.getString("address");
        boolean deliveried = result.getBoolean("deliveried");
        Order order = new Order(id, customerName, total, orderTime, mobile, address,deliveried);
        orderList.add(order);
		}
		return orderList;
	}
	
	
	public Order getOrder(int orderId) throws SQLException{
		List<Order> orderList = new ArrayList<>();
		Connection conn = dataSource.getConnection();
		String sql = "select * from orders where id=?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, orderId);
		ResultSet result = stmt.executeQuery();
		Order order = null;
		while(result.next())
		{
		int id = result.getInt("id");
		 String customerName=result.getString("customer_name");
        Double total = result.getDouble("total");
        Timestamp orderTime=result.getTimestamp("order_time");
        String mobile = result.getString("mobile");
        String address = result.getString("address");
        boolean deliveried = result.getBoolean("deliveried");
        order = new Order(id, customerName, total, orderTime, mobile, address,deliveried);
      
		}
		return order;
	}
	
	public int orderUpdate(Order order) throws SQLException
	{
		Connection conn = dataSource.getConnection();
		String sql = "update  orders set total=?,order_time=?,customer_name=?,mobile=?,address=?,deliveried=? where id=?";
		PreparedStatement stmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		stmt.setDouble(1, order.getTotal());
		stmt.setTimestamp(2, order.getOrderTime());
		stmt.setString(3, order.getCustomerName());
		stmt.setString(4, order.getMobile());
		stmt.setString(5, order.getAddress());
		stmt.setBoolean(6, order.isDeliveried());
		stmt.setInt(7, order.getId());
		int row = stmt.executeUpdate();
		return row;
	}
	
	public int counterOrders() throws SQLException {
		
		Connection conn = dataSource.getConnection();
		String sql = "select count(*) as count from orders where deliveried=?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setBoolean(1, false);
		ResultSet result = stmt.executeQuery();
		result.next();
		
		int count = result.getInt("count");
		
		
		return count;
	}
	
}
