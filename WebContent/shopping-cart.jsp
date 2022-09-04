<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*,com.code2.dao.*,com.code2.modal.*" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
		<div class="container">
		<nav class="navbar navbar-expand-lg navbar-dark bg-info mt-3 rounded">
  <a class="navbar-brand" href="/shopping-cart/Home">Back To</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav">
      <li class="nav-item active">
        <a class="nav-link" href="/shopping-cart/home.jsp">Home <span class="sr-only">(current)</span></a>
      </li>
    </ul>
  </div>
</nav>
		
		
		
	<div>
	<h1 class="h2 mt-5">Shopping Cart</h1>
	<table class='table'>
		<thead>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Price</th>
				<th>Qty</th>
				<th>SubTotal</th>
			</tr>
		</thead>
		<tbody>
	
					<c:forEach var="tmpCart" items="${shoppingCart.cartItems}">    <!-- two steps to get CartItem model to add total -->
					<tr>
						<td>${tmpCart.productId }</td>
						<td>${tmpCart.productName }</td>
						<td>${tmpCart.prodictPrice }</td>
						<td>${tmpCart.quantity}</td>
						<td>${tmpCart.prodictPrice * tmpCart.quantity }</td>
					</tr>
					</c:forEach>
					
					<tr>
						<td></td><td></td><td></td>
						<td>Total:</td>
						<td>
							${shoppingCart.total}
						</td>
					</tr>
					
					<tr>
						<td></td><td></td><td></td><td></td>
						<td>
							<a href="${pageContext.request.contextPath }/checkout">CheckOut</a>
						</td>
						<td></td>
					</tr>
		</tbody>
	</table>
	</div>
	</div>
</body>
</html>