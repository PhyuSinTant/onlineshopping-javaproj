<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*,com.code2.dao.*,com.code2.modal.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="/shopping-cart/Home">Back To</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav">
				<li class="nav-item active"><a class="nav-link"
					href="${pageContext.request.contextPath}/Home">Home <span
						class="sr-only">(current)</span></a></li>
			</ul>
		</div>
	</nav>


	<div class="container">
		<div class="row mt-5">
			<div class="col-md-3">
				<img src="${ProductList.imgUrl}" width="150px">
			</div>
			<div class="col-md-9">
				<p>${ProductList.id}</p>
				<p>${ProductList.name}</p>
				<p>${ProductList.price}</p>
				<form action="${pageContext.request.contextPath}/shoppingCart"
					method="POST">
					<input type='hidden' name="productId" value="${ProductList.id}">
					<input type='hidden' name="command" value="ADD">
					<lable>Quality:</lable>
					<select class="mx-3" name="quantity">
						<option>1</option>
						<option>2</option>
						<option>3</option>
						<option>4</option>
					</select> 
					<input type="submit" class="btn btn-primary" value="Add">
				</form>
			</div>
		</div>
	</div>
</body>
</html>