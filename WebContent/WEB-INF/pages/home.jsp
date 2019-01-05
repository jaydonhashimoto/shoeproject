<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>SJ Shoes</title>
</head>
<body>
	<!-- bootstrap container -->
	<div class="container">
  		<div class="row">
    		<div class="col">
				<div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
				  <ol class="carousel-indicators">
				    <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
				    <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
				    <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
				  </ol>
				  <div class="carousel-inner">
				    <div class="carousel-item active">
				      <img class="img-fluid" src="${pageContext.request.contextPath}/resources/images/carouselpic1.jpg" alt="First slide">
				      	<div class="carousel-caption d-none d-md-block">
				    		<h5 class="home_text">Discover Shoes</h5>
				    		<p class="home_text">Check out our wide range of shoes</p>
				  		</div>
				    </div>
				    <div class="carousel-item">
				      <img class="img-fluid" src="${pageContext.request.contextPath}/resources/images/carouselpic2.jpg" alt="Second slide">
				      	<div class="carousel-caption d-none d-md-block">
				    		<h5 class="home_text">Sales</h5>
				    		<p class="home_text">Check out what is on sale</p>
				  		</div>
				    </div>
				    <div class="carousel-item">
				      <img class="img-fluid" src="${pageContext.request.contextPath}/resources/images/carouselpic3.jpg" alt="Third slide">
				      	<div class="carousel-caption d-none d-md-block">
				    		<h5 class="home_text">Contact Us</h5>
				    		<p class="home_text">See our contact information</p>
				  		</div>
				    </div>
				  </div>
				  <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
				    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
				    <span class="sr-only">Previous</span>
				  </a>
				  <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
				    <span class="carousel-control-next-icon" aria-hidden="true"></span>
				    <span class="sr-only">Next</span>
				  </a>
				</div>
			</div>
		</div>
	</div>
</body>
