<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<body>
	<h2 align="center">Our Shoes</h2>
	<!-- bootstrap table of shoes -->
	<table class="table table-striped">
		<!-- labels -->
		<tr>
			<th scope="col"><label>Brand</label></th>
			<th scope="col"><label>Color</label></th>		
			<th scope="col"><label>Size</label></th>
			<th scope="col"><label>Price</label></th>								
		</tr>
		<!-- populate rows with shoes -->
		<c:forEach var="shoes" items="${shoes}">
			<tr>	
				<td><label>${shoes.brand}</label></td>
				<td><label>${shoes.color}</label></td>
				<td><label>${shoes.size}</label></td>
				<td><label>$${shoes.price}</label></td>
				<!-- buy button -->
				<td>
					<!-- Button trigger modal -->
					<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#buy">
					  Buy
					</button>
					
					<!-- Modal -->
					<div class="modal fade" id="buy" tabindex="-1" role="dialog" aria-labelledby="buyLabel" aria-hidden="true">
					  <div class="modal-dialog" role="document">
					    <div class="modal-content">
					      <div class="modal-header">
					        <h5 class="modal-title" id="buyLabel">You have purchased this shoe!</h5>
					        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
					          <span aria-hidden="true">&times;</span>
					        </button>
					      </div>
					      <div class="modal-footer">
					        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
					      </div>
					    </div>
					  </div>
					</div>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>

