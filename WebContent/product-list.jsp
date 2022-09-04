<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin - Product</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
<div class="container">
<nav class="navbar navbar-expand-lg navbar-dark bg-info mt-3 rounded">
  <a class="navbar-brand" href="${pageContext.request.contextPath}/Home">O shop-Admin</a>
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
		<h1 class="h2 mt-3">Product List
		<a class="btn btn-success f-right" href="${pageContext.request.contextPath}/products?command=ADD"><i class="fa fa-plus" aria-hidden="true"></i></a>
		</h1>
		
		</div>
	</div>
	
	<div class="row">
		<div class="col-md-12">
	
	<table class="table">
		<thead>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Image</th>
				<th>Price</th>
				<th>Action</th>
			</tr>
		</thead>
		
			<c:forEach var="tmpProduct" items="${Product}">
			<tbody>
			
				<td>${tmpProduct.id}</td>
				<td>${tmpProduct.name}</td>
				<td><img src="${tmpProduct.imgUrl}" alt="Product" width="100px"></td>
				<td>${tmpProduct.price}</td>
				<td>
				<a class="btn btn-danger" href="${pageContext.request.contextPath}/products?command=DELETE&id=${tmpProduct.id}"><i class="fa fa-trash" aria-hidden="true"></i></a>
				<a href="${pageContext.request.contextPath}/products?command=EDIT&id=${tmpProduct.id}"><i class="fa fa-pencil-square-o" aria-hidden="true"></i></a></td>
			</tbody>
			</c:forEach>
		
	</table>
		</div>
	</div>
</div>
</body>
</html>