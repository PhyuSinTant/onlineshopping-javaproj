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
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import com.code2.dao.OrderDAO;
import com.code2.dao.ProductDAO;
import com.code2.modal.User;

/**
 * Servlet implementation class AdimController
 */
@WebServlet("/admin")
public class AdimController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	@Resource(name="jdbc/ProductDemo")
	private DataSource dataSource;
	private OrderDAO orderDAO;
	private ProductDAO productDAO;
    public AdimController() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init() throws ServletException
    {
    	//ProductDAO product = new ProductDAO(dataSource);
    	orderDAO = new OrderDAO(dataSource);
    	productDAO = new ProductDAO(dataSource);
    }


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//authentication
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("currentUser");
		if(user!=null) {
			 try {
					int orderCount =orderDAO.counterOrders();
					request.setAttribute("orderCount", orderCount);
					int productCount = productDAO.countProducts();
					request.setAttribute("productCount", productCount);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				RequestDispatcher dispatcher = request.getRequestDispatcher("admin.jsp");
				dispatcher.forward(request, response);
			}
		else {
			response.sendRedirect(request.getContextPath()+"/login");
		}
		}
		
		
		
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
