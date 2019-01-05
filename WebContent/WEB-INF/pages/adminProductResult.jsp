<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<body>
	<h2 align="center">Our Shoes</h2>
	<!-- bootstrap table of shoes -->
	<table class="table table-responsive-sm table-striped">
		<!-- labels first row -->
		<tr>
			<th scope="col"><label>ID</label></th>
			<th scope="col"><label>Brand</label></th>
			<th scope="col"><label>Color</label></th>		
			<th scope="col"><label>Size</label></th>
			<th scope="col"><label>Price</label></th>								
		</tr>
		<!-- populate rows with shoes -->
		<c:forEach var="shoes" items="${shoes}">
			<tr>	
				<td><label>${shoes.id}</label></td>		
				<td><label>${shoes.brand}</label></td>
				<td><label>${shoes.color}</label></td>
				<td><label>${shoes.size}</label></td>
				<td><label>$${shoes.price}</label></td>
				<!-- update button -->
				<td>
					<!-- send shoe data to update page -->
					<form:form method="POST" modelAttribute="shoe" action="update" autocomplete="off">
						<input id="id" name="id" type="hidden" value="${shoes.id}"/>
						<input id="brand" name="brand" type="hidden" value="${shoes.brand}"/>
						<input id="color" name="color" type="hidden" value="${shoes.color}"/>
						<input id="size" name="size" type="hidden" value="${shoes.size}"/>
						<input id="price" name="price" type="hidden" value="${shoes.price}"/>
						<button type="submit" class="btn btn-success">Update</button>
						<br/>
					</form:form>
				</td>
				<!-- delete button -->
				<td>
					<!-- send shoe id to delete shoe method -->
					<form:form method="POST" modelAttribute="shoe" action="deleteproduct" autocomplete="off">
						<input id="id" name="id" type="hidden" value="${shoes.id}"/>
						<button type="submit" class="btn btn-danger">Delete</button>
					</form:form>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>

