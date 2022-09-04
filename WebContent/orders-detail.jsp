<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin - Order</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>

<div class="container">
<nav class="navbar navbar-expand-lg navbar-dark bg-info mt-3 rounded">
  <a class="navbar-brand" href="productdetail/">O shop-Admin</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav">
      <li class="nav-item active">
        <a class="nav-link" href="${pageContext.request.contextPath}/products">Products</a>
      </li>
     
      <li class="nav-item">
        <a class="nav-link" href="${pageContext.request.contextPath}/orders">Orders</a>
      </li>
     
    </ul>
  </div>
</nav>


	<div class="row">
	<div class="col-md-12">
	<h1 class="h3">Order Detail</h1>
	</div>
	</div>
	
	<div class="row">
	<div class="col-md-8">
	<table class="table">
	
		<thead>
			<tr>
				<th>Order Id</th>
				<th>Product Name</th>
				<th>Price</th>
				<th>Qualtity</th>
			<tr>
		</thead>
		
		<tbody>
			<c:forEach var="tmpOrder" items="${OrderItem}">
					<tr>
						<td>${tmpOrder.productId}</td>
						<td>${tmpOrder.productName }</td>
						<td>${tmpOrder.productPrice * tmpOrder.quantity}</td>
						<td>${tmpOrder.quantity }</td>
					</tr>
			</c:forEach>
			<tr>
				<td></td>
				<td>Total</td>
				<td>${order.total}</td>
			</tr>
		</tbody>
		
	</table>
	</div>
	
	<div class="col-md-4">
		<p>Customer Name: ${order.customerName}</p>
		<p>Mobile: ${order.mobile}</p>
		<p>Address: ${order.address}</p>
		
		<div>
		<a class="btn btn-warning" href="${pageContext.request.contextPath}/orders?command=DELIVERY&orderId=${order.id}">Deliver</a>
		</div>
	</div>
	</div>
	</div>
	
</div>
</body>
</html>