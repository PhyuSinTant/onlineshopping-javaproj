package com.code2.controller;


import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import com.code2.dao.ProductDAO;
import com.code2.modal.Product;
import com.code2.modal.User;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/products")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(name="jdbc/ProductDemo")
	private DataSource dataSource;
	private ProductDAO productDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
    public ProductServlet() {
       
    }
    
    public void init() throws ServletException
    {
    	//ProductDAO product = new ProductDAO(dataSource);
    	 productDAO = new ProductDAO(dataSource);
    	
    
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// authentication
				HttpSession session = request.getSession();
				User user = (User) session.getAttribute("currentUser");
				if(user!=null) {
					String command = request.getParameter("command");
					if(command==null) {
						command="LIST";
					}
					
					switch(command)
					{
					case "LIST" :
						showProductList(request,response);
						break;
					case "ADD" :
						RequestDispatcher dispatcher2 = request.getRequestDispatcher("new-product.jsp");
						dispatcher2.forward(request, response);
						break;
					case "SAVE" :
						SaveProduct(request,response);
						
						break;
					case "SHOW" :
						RequestDispatcher dispatcher4 = request.getRequestDispatcher("product-detail.jsp");
						dispatcher4.forward(request, response);
						break;
					case "EDIT" :
						showEditProduct(request,response);
						break;
					case "UPDATE" :
						updateProduct(request,response);
						
						break;
					case "DELETE" :
						DeleteProduct(request,response);
						break;
					}
				
				}
				else {
					response.sendRedirect(request.getContextPath()+"/login");
				}
				}
		
	private void updateProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("productName");
		String url= request.getParameter("imgUrl");
		Double price =Double.parseDouble((request.getParameter("price")));
		
		try {
			Product product = productDAO.getProduct(id);
			product.setName(name);
			product.setImgUrl(url);
			product.setPrice(price);
			productDAO.updateUpdate(product);
			
		}
		catch(SQLException e)
		{
    		e.printStackTrace();
    	}
		response.sendRedirect(request.getContextPath()+"/products");	
		
	}

	private void showEditProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id =Integer.parseInt(request.getParameter("id")) ;
		try {
			Product product = productDAO.getProduct(id);
			request.setAttribute("product", product);
			
		}
		catch(SQLException e) {
    		e.printStackTrace();
    	}
		
		RequestDispatcher dispatcher5 = request.getRequestDispatcher("edit-product.jsp");
		dispatcher5.forward(request, response);
		
		
	}

	private void DeleteProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
	  int id = Integer.parseInt(request.getParameter("id")) ;
	  try {
		  productDAO.deleteProduct(id);
	  }
	  catch(SQLException e) {
  		e.printStackTrace();
  	}
	  response.sendRedirect(request.getContextPath()+"/products");
		
	}

	private void showProductList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			List<Product> products = productDAO.getProducts();
			request.setAttribute("Product", products);
		}
		catch(SQLException e) {
    		e.printStackTrace();
    	}
		RequestDispatcher dispatcher1 = request.getRequestDispatcher("product-list.jsp");
		dispatcher1.forward(request, response);
		
	}
	
	

	private void SaveProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("productName");
		String url= request.getParameter("imgUrl");
		Double price =Double.parseDouble((request.getParameter("price")));
		Product product = new Product(name, url, price);
    	try {
    		productDAO.saveProduct(product);
    		System.out.println("Save");
    		
    	}
    	catch(SQLException e) {
    		e.printStackTrace();
    	}
    	response.sendRedirect(request.getContextPath()+"/products");
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
