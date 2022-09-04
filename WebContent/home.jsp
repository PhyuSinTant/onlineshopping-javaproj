<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*,com.code2.dao.*,com.code2.modal.*" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Shopping Cart</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
	
	<!-- <%
	//ProductDAO productDAO = new ProductDAO();
	//List<Product>products = productDAO.getProduct();
	//%>
	 -->
	
	<nav class="navbar navbar-expand-lg navbar-dark bg-info rounded">
  
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav">
      <li class="nav-item active">
        <a class="nav-link" href="${pageContext.request.contextPath}/Home">Home</a>
      </li>
      
      <li class="nav-item">
        <a class="nav-link" href="<c:url value="shoppingCart"/>">Shopping Carts</a>
      </li>
    </ul>
  </div>
</nav>
	

	
	


	
	
	
	<!-- <%
	
	//pageContext.setAttribute("ProductList", products);
		
	%> -->
	
	
	<div class="container" >
	<div class="row mt-5">
	
		<c:forEach var="tmpProduct" items="${ProductList}">
		
			<div class='col col-md-2  offset-md-1'>
			<div class='<card-group>'>
			<div class='<card> border-primary mb-3 style='max-width: 18rem' mt-5 rounded-0'>
			<img src="${tmpProduct.imgUrl}" class='card-md-5 w-100 h-100'>
			<div class='<card-body>'>
			<p>${tmpProduct.id}</p>
			<p>${tmpProduct.price}</p>
			<p><a href="productdetail?id=${tmpProduct.id}">${tmpProduct.name}</a></p>
			</div>
			</div>
			</div>
			</div>
			
		</c:forEach>
	
	</div>
	</div>
	
</body>
</html>