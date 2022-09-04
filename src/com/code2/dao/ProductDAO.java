package com.code2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.code2.modal.Product;



public class ProductDAO {
	
		private DataSource dataSource;

		public ProductDAO(DataSource dataSource)
		{
		
			this.dataSource = dataSource;
		}
		
		public int countProducts() throws SQLException {
			Connection conn = dataSource.getConnection();
			String sql = "select count(*) as count from products";
			Statement stmt = conn.createStatement();
			ResultSet result = stmt.executeQuery(sql);
			result.next();
			int count = result.getInt("count");
			return count;
		}
		
		public void saveProduct(Product product) throws SQLException 
		{
			Connection conn = dataSource.getConnection();
			String sql = "insert into products (name,img_url,price) value(?,?,?)";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, product.getName());
			stmt.setString(2, product.getImgUrl());
			stmt.setDouble(3, product.getPrice());
			stmt.executeUpdate();
		}
		
		public List<Product> getProducts() throws SQLException{
			List<Product> productList = new ArrayList<>();
			Connection conn = dataSource.getConnection();
			String sql = "select * from products";
			Statement stmt = conn.createStatement();
			ResultSet result = stmt.executeQuery(sql);
			while(result.next())
			{
			int id = result.getInt("id");
	        String name = result.getString("name");
	        String imgUrl=result.getString("img_url");
	        Double price=result.getDouble("price");
	        Product product = new Product(id, name, imgUrl, price);
	        productList.add(product);
			}
			
			
			return productList;
		}
		
		public void deleteProduct(int productId) throws SQLException {
			Connection conn = dataSource.getConnection();
			String sql = "delete from products where id =?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1,productId);
			stmt.executeUpdate();
		}
		
		public Product getProduct(int productId) throws SQLException {
			Connection conn = dataSource.getConnection();
			String sql = "select * from products where id=?";
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, productId);
			ResultSet result = stmt.executeQuery();
			Product product=null;
			if(result.next()) {
				int id = result.getInt("id");
		        String name = result.getString("name");
		        String imgUrl=result.getString("img_url");
		        Double price=result.getDouble("price");
		        product = new Product(id, name, imgUrl, price);
		       
			}
			
			return product;
		}
		
		public void updateUpdate(Product product) throws SQLException
		{
			Connection conn = dataSource.getConnection();
			String sql = "update products set name=?,img_url=?,price=? where id=?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, product.getName());
			stmt.setString(2, product.getImgUrl());
			stmt.setDouble(3, product.getPrice());
			stmt.setInt(4, product.getId());
			stmt.executeUpdate();
		}

		
		
}
