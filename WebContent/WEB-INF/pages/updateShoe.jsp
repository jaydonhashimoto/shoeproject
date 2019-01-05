<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<body>
<!-- bootstrap container -->
<div class="container">
		<div class="row">
			<div class="col">
				<!-- update shoe form -->
				<form:form method="POST" modelAttribute="shoe" action="updateproduct" autocomplete="off" id="input_field">
					<h2>Update Shoe</h2>
					<input id="id" name="id" type="hidden" value="${shoe.id}"/>
					<div class="form-group">
						<label for="brand">Brand</label>
					    <form:input value="${shoe.brand}" maxlength="20" path="brand" type="text" class="form-control" id="brand" placeholder="Enter Brand"/>
					    <small class="form-text text-muted"><form:errors path="brand"/></small>
					 </div>
					<div class="form-group">
						<label for="color">Color</label>
					    <form:input value="${shoe.color}" maxlength="20" path="color" type="text" class="form-control" id="color" placeholder="Enter Color"/>
					    <small class="form-text text-muted"><form:errors path="color"/></small>
					 </div>
					 <div class="form-group">
						<label for="size">Size</label>
					    <form:input value="${shoe.size}" maxlength="3" path="size" type="text" class="form-control" id="size" placeholder="Enter Size"/>
					    <small class="form-text text-muted"><form:errors path="size"/></small>
					 </div>
					 <div class="form-group">
						<label for="price">Price</label>
						 	<div class="input-group-prepend">
   							 	<span class="input-group-text">$</span>
    							<span class="input-group-text">0.00</span>
 							 </div>
					   	<form:input value="${shoe.price}" maxlength="6" path="price" type="text" class="form-control" id="price" placeholder="Enter Price"/>
					    <small class="form-text text-muted"><form:errors path="price"/></small>
					 </div>
					 	<button type="submit" class="btn btn-primary">Update</button>
				</form:form>
			</div>
		</div>
	</div>
</body>