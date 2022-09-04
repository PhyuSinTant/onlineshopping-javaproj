<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>O Shop - Check Out</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-info rounded">
  <a class="navbar-brand" href="productdetail/">O shop</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav">
      <li class="nav-item active">
        <a class="nav-link" href="${pageContext.request.contextPath}/Home">Home</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="productdetail?id=${tmpProduct.id}>">O Shop</a>
      </li>
      
    </ul>
  </div>
</nav>


<div class="container">
	<div class="row mt-5">
		<div class="col-md-4 mx-auto">
	<form action="${pageContext.request.contextPath}/orders" method="POST">
		<input type="hidden" name="command" value="ADD">
		<div class="form-group">
		<label>Cusotmer Name</label>
		<input type ="text" name="customername" class="form-control">
		</div>
		<div class="form-group">
		<label>Mobile</label>
		<input type ="text" name="mobile" class="form-control">
		</div>
		<div class="form-group">
		<label>Address</label>
		<textarea rows="5" cols="20" name="address" class="form-control"></textarea>
		</div>
		<input type="submit" class="btn btn-primary btn-block" value="Order Now">
	</form>
	</div>
	</div>
</div>
</body>
</html>