<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>O Shop - Admin</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
	.fa{
	font-size:36px;
	}
	.count{
	font-weight:bold;
	}
	.box{
	box-shadow:2px 2px 1px #424242;
	}
</style>

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
    <ul class="navbar-nav ml-auto">
    	<li class="nav-item">
    		<a class="btn btn-secondary" href="${pageContext.request.contextPath }/logout">Logout</a>
    	</li>
    </ul>
  </div>
</nav>

		<div class="row mt-3">
			
			<div class="col-md-3 border ">
			<div class="row box">
			<div class="col-md-4 bg-primary text-center text-white">
			<i class="fa fa-cubes mt-4" aria-hidden="true"></i>
			</div>
			<div class="col-md-6">
			<p class="mb-0 mt-3">Product</p>
			<p class="count">${productCount}</p>
			</div>
			
		</div>
		
		</div>
		<div class="col-md-3 mx-3 border">
			<div class="row box">
			<div class="col-md-4 bg-warning text-center text-white">
			<i class="fa fa-cubes mt-4" aria-hidden="true"></i>
			</div>
			<div class="col-md-6">
			<p class="mb-0 mt-3">Order</p>
			<p class="count">${orderCount}</p>
			</div>
		</div>
		
	<!-- <div class="col-md-3 border mx-3">
			<div class="col-md-3 ">
			<div class="row box">
			<div class="col-md-6 bg-warning text-center text-white">
			<i class="fa fa-cubes mt-4" aria-hidden="true"></i>
			</div>
			<div class="col-md-6">
			<p class="mb-0 mt-3">Product</p>
			<p>100</p>
			</div>
		</div>
</div> -->
</div>
</div>
</body>
</html>