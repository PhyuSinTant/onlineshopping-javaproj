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
import com.code2.modal.CartItem;
import com.code2.modal.Product;
import com.code2.modal.ShoppingCart;

/**
 * Servlet implementation class shoppingCartServlet
 */
@WebServlet("/shoppingCart")
public class shoppingCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	@Resource(name="jdbc/ProductDemo")
	private DataSource dataSource;
	private ProductDAO productDAO;
    public shoppingCartServlet() {
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
		String command = request.getParameter("command");
		if(command==null) {
			command="SHOW";
		}
		
		switch(command) {
		case "SHOW":
			showShoppingCartItem(request, response);
			
			break;
		case "ADD":
			addItemToShoppingCart(request, response);
			break;
		}
		
	}

	private void showShoppingCartItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		ShoppingCart shoppingCart = (ShoppingCart)session.getAttribute("shoppingCart");
		request.setAttribute("shoppingCart", shoppingCart);
		RequestDispatcher dispatcher = request.getRequestDispatcher("shopping-cart.jsp");
		dispatcher.forward(request, response);
	}

	private void addItemToShoppingCart(HttpServletRequest request, HttpServletResponse response) throws  ServletException, IOException {
		
		HttpSession session = request.getSession();
		ShoppingCart shoppingCart = (ShoppingCart)session.getAttribute("shoppingCart");
		if( shoppingCart==null)
		{
			shoppingCart = new ShoppingCart(new ArrayList<>(),0);
			session.setAttribute("shoppingCart",shoppingCart);
		}
		
		String strId= request.getParameter("productId");
		String qtyStr= request.getParameter("quantity");
		int id= Integer.parseInt(strId);
		int  qty= Integer.parseInt(qtyStr);
		
		boolean isProductExists=false;
		
		for(CartItem item:shoppingCart.getCartItems())
		{
			if(id==item.getProductId())
			{
				item.setQuantity(item.getQuantity()+qty);
				shoppingCart.setTotal(shoppingCart.getTotal()+(item.getProdictPrice()*qty));
				isProductExists = true;
			}

		}
		//System.out.println(isProductExists);
		if(!isProductExists)
		{
				Product product;
				try {
					product = productDAO.getProduct(id);
					CartItem item=new CartItem(product.getId(),product.getName(),product.getPrice(),qty);
					shoppingCart.getCartItems().add(item);
					shoppingCart.setTotal(shoppingCart.getTotal()+(product.getPrice()*qty));
				}
				catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("add-shopping-cart.jsp");
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
