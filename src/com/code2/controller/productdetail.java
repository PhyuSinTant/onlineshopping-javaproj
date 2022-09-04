package com.code2.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.code2.dao.ProductDAO;
import com.code2.modal.Product;

/**
 * Servlet implementation class productdetail
 */
@WebServlet("/productdetail")
public class productdetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	@Resource(name="jdbc/ProductDemo")
	private DataSource dataSource;
	private ProductDAO productDAO;
    public productdetail() {
        super();
        // TODO Auto-generated constructor stub
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
		int id=Integer.parseInt(request.getParameter("id"));			//getting the id from home.jsp, id='"+product.getId+"'
		
		try
		{
		
			 Product product = productDAO.getProduct(id);
			 request.setAttribute("ProductList", product);
		} 
		catch (SQLException e) 
		{
			
			e.printStackTrace();
		}	
		RequestDispatcher dispatcher = request.getRequestDispatcher("product_detail.jsp");
		
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
