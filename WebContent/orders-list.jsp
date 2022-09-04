<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin - Order List</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>

<div class="container">
<nav class="navbar navbar-expand-lg navbar-dark bg-info mt-3 rounded">
  <a class="navbar-brand" href="${pageContext.request.contextPath}/admin">O shop-Admin</a>
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
		<h1 class="h3 my-3">Order List</h1>
	</div>
	<div>
<table class='table'>
	
		<thead>
			<tr>
				<th>Order Id</th>
				<th>Customer Name</th>
				<th>Total</th>
				<th>Date Time</th>
				<th>Mobile</th>
				<th>Address</th>
				<th>Action</th>
				
			<tr>
		</thead>
		
		<tbody>
			<c:forEach var="tmpOrder" items="${Order}">
					<tr>
						<td>${tmpOrder.id}</td>
						<td>${tmpOrder.customerName }</td>
						<td>${tmpOrder.total }</td>
						<td>${tmpOrder.orderTime}</td>
						<td>${tmpOrder.mobile}</td>
						<td>${tmpOrder.address}</td>
						<td><a href="${pageContext.request.contextPath}/orders?command=SHOW&OrderId=${tmpOrder.id}">Show</a></td>
						
					</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
</div>
</body>
</html>