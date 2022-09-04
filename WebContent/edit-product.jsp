<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Product</title>
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

	<div class="container">
	
	<div class="row mt-5">
		<div class="col-md-4 mx-auto">
		<h1>New Product</h1>
	<form action="${pageContext.request.contextPath}/products" method="GET">
		<input type="hidden" name="id" value="${product.id }">
		<input type="hidden" name="command" value="UPDATE">
		<div class="form-group">
		<label>Product Name:</label>
		<input type="text" name="productName" value="${product.name}" class="form-control" /> 
		</div>
		<div class="form-group">
		<label>Image Url:</label>
		<input type="text" name="imgUrl" value="${product.imgUrl}" class="form-control"/> 
		</div>
		<div class="form-group">
		<label>Price:</label>
		<input type="text" name="price" value="${product.price}" class="form-control"/> 
		</div>
		<input type="submit" value="Submit" class="btn btn-primary btn-block"/> 
	</form>
	</div>
	</div>
	</div>
</div>
</body>
</html>