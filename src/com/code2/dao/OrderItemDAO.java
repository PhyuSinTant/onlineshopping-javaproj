package com.code2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.code2.modal.Order;
import com.code2.modal.OrderItem;

public class OrderItemDAO {
	private DataSource dataSource;
	
	public OrderItemDAO(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}

	public void saveOrderItem(OrderItem orderItem) throws SQLException {
		Connection conn = dataSource.getConnection();
		String sql = "insert into order_items (product_id,product_name,price,quantity,order_id) value(?,?,?,?,?)";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, orderItem.getProductId());
		stmt.setString(2, orderItem.getProductName());
		stmt.setDouble(3, orderItem.getProductPrice());
		stmt.setInt(4, orderItem.getQuantity());
		stmt.setInt(5, orderItem.getOrderId());
		stmt.executeUpdate();
	}
	
	public List<OrderItem> getOrder(int orderId) throws SQLException {
		Connection conn = dataSource.getConnection();
		String sql = "select * from order_items where order_id=?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, orderId);
		ResultSet result = stmt.executeQuery();
		List<OrderItem> orderItemList = new ArrayList<>();
		OrderItem orderItem=null;
		while(result.next()) {
			int id = result.getInt("id");
			int productId = result.getInt("product_id");
	        String name = result.getString("product_name");
	        Double price=result.getDouble("price");
	        int quantity=result.getInt("quantity");
	        int OrderId= result.getInt("order_id");
	        orderItem = new OrderItem(id, productId, name, price, quantity, OrderId);
	        orderItemList.add(orderItem);
		}
		
		return orderItemList;
	}
}
