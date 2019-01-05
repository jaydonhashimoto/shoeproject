<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<body>
<div class="container">
	<div class="row">
		<div class="col">
			<h2 align="center">Our Shoes</h2>
			<!-- bootstrap table of shoes -->
			<table class="table table-striped" id="guest_table">
				<!-- header first row -->
				<tr>
					<th scope="col"><label>Brand</label></th>
					<th scope="col"><label>Color</label></th>		
					<th scope="col"><label>Size</label></th>
					<th scope="col"><label>Price</label></th>								
				</tr>
				<!-- populate each row with shoes -->
				<c:forEach var="shoes" items="${shoes}">
					<tr>	
						<td><label>${shoes.brand}</label></td>
						<td><label>${shoes.color}</label></td>
						<td><label>${shoes.size}</label></td>
						<td><label>$${shoes.price}</label></td>
					</tr>
				</c:forEach>
			</table>	
		</div>
	</div>
</div>
</body>

