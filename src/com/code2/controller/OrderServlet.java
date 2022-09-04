package com.code2.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
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

import com.code2.dao.OrderDAO;
import com.code2.dao.OrderItemDAO;
import com.code2.dao.ProductDAO;
import com.code2.modal.CartItem;
import com.code2.modal.Order;
import com.code2.modal.OrderItem;
import com.code2.modal.Product;
import com.code2.modal.ShoppingCart;
import com.code2.modal.User;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/orders")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	@Resource(name = "jdbc/ProductDemo")
	private DataSource dataSource;
	private OrderDAO orderDAO;
	private OrderItemDAO orderItemDAO;

	public OrderServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void init() throws ServletException {
		// ProductDAO product = new ProductDAO(dataSource);
		orderDAO = new OrderDAO(dataSource);
		orderItemDAO = new OrderItemDAO(dataSource);

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// authentication
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("currentUser");

		if(user!=null) {
			String command = request.getParameter("command");
			if (command == null) {
				command = "LIST";
			}

			switch (command) {
			case "LIST":
				showOrders(request, response);
				break;
			
			case "SHOW":
				showOrderDetail(request, response);
				break;
			case "DELIVERY":
				setOrderAsDeliveried(request, response);
				break;
			}
			

		}	else {
			response.sendRedirect(request.getContextPath()+"/login");
		}
		}
		

	private void setOrderAsDeliveried(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int orderId = Integer.parseInt(request.getParameter("orderId"));
		try {
			Order order = orderDAO.getOrder(orderId);
			order.setDeliveried(true);
			orderDAO.orderUpdate(order);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		response.sendRedirect(request.getContextPath() + "/orders");

	}

	private void showOrderDetail(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String strId = request.getParameter("OrderId");
		int id = Integer.parseInt(strId);
		try {
			Order order = orderDAO.getOrder(id);
			List<OrderItem> orderItem = orderItemDAO.getOrder(id);
			request.setAttribute("OrderItem", orderItem);
			request.setAttribute("order", order);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("orders-detail.jsp");
		dispatcher.forward(request, response);

	}

	private void addOrders(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		HttpSession session = request.getSession();
		ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("shoppingCart");
		if (shoppingCart != null) {
			if (shoppingCart.getCartItems().size() > 0) {
				String customer = request.getParameter("customername");
				String mobile = request.getParameter("mobile");
				String address = request.getParameter("address");
				// boolean deliveried=request.getParameter("deliveried")
				Order order = new Order(customer, shoppingCart.getTotal(), new Timestamp(System.currentTimeMillis()),
						mobile, address, false);
				try {
					Order saveOrder = orderDAO.saveOrder(order);
					System.out.println("Id:" + saveOrder.getId());

					for (CartItem cartItem : shoppingCart.getCartItems()) {

						OrderItem orderItem = new OrderItem(cartItem.getProductId(), cartItem.getProductName(),
								cartItem.getProdictPrice(), cartItem.getQuantity(), saveOrder.getId());
						orderItemDAO.saveOrderItem(orderItem);

					}
					session.removeAttribute("shoppingCart");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("ordersuccess.jsp");
		dispatcher.forward(request, response);

		//response.sendRedirect(request.getContextPath() + "/Home");

	}

	private void showOrders(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// List<Product> products = productDAO.getProducts();
		// request.setAttribute("Product", products);

		try {
			List<Order> orders = orderDAO.getOrders();
			request.setAttribute("Order", orders);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("orders-list.jsp");
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		addOrders(request,response);
	}

}
