<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<style>
	body {
		background: url("${pageContext.request.contextPath}/resources/images/landing_bg1.jpg");
		background-size: cover;
	}
	.landing {
		margin-top: 20vh;
		background: rgba(86,86,86,0.7);
		color: #f4f4f4;
		padding-bottom: 20px; 
		padding-up: 20px; 
	}
</style>
<body>
<!-- bootstrap container -->
<div class="container-full-bg">
	<div class="landing">
		<h1 class="display-4"><b>SJ Shoes</b></h1>
		<p class="lead">Discover yourself by discovering your shoes.</p>
		<p>Check out our inventory and find the latest and greatest designer shoes!</p>
		<!-- navigate to home page -->
		<a class="btn btn-secondary btn-lg" href="/shoeproject/home" role="button">Shop Now</a>
	</div>
</div>
</body>
