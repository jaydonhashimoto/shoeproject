<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<script type="text/javascript">
	function getUsers() {
		//jquery ajax method
		$.ajax(
				{
					//http method
					type: "GET",
					//api url
					url: "/shoeproject/service/users",
					//return type
					dataType: "json",
					//success function
					success: function(data)
					{
						//populate users table with json data
						$('#users').dataTable({
							//data table responsiveness
							"responsive": true,
							//populate data
							"data": data,
							"columns": [{"data": "email"},
								{"data": "firstName"},
								{"data": "lastName"},
								{"data": "admin"}]
						});
					},
					//error function
					error: function(xhr, ajaxOptions, thrownError)
					{
						//show alert with error msg
						alert(xhr.status);
						alert(thrownError);
					}
				});
	}
	//call function when document is ready
	$(document).ready(getUsers);
</script>
<body>
	<!-- wrap everything in bootstrap container -->
	<div class="container">
		<!-- first row is page header -->
		<div class="row justify-content-md-center">
			<div class="col col-md-auto">
				Administrator Features
			</div>
		</div>
		<!-- set add product in second row -->
		<div class="row justify-content-md-center">
			<div class="col">
				<!-- add product method -->
				<form:form method="POST" modelAttribute="shoe" action="addproduct" autocomplete="off" id="input_field">
					<div class="form-group">
						<label for="brand">Brand</label>
					    <form:input maxlength="20" path="brand" type="text" class="form-control" id="brand" placeholder="Enter Brand"/>
					    <small class="form-text text-muted"><form:errors path="brand"/></small>
					 </div>
					<div class="form-group">
						<label for="color">Color</label>
					    <form:input maxlength="20" path="color" type="text" class="form-control" id="color" placeholder="Enter Color"/>
					    <small class="form-text text-muted"><form:errors path="color"/></small>
					 </div>
					 <div class="form-group">
						<label for="size">Size</label>
					    <form:input maxlength="3" path="size" type="text" class="form-control" id="size" placeholder="Enter Size"/>
					    <small class="form-text text-muted"><form:errors path="size"/></small>
					 </div>
					 <div class="form-group">
						<label for="price">Price</label>
						 	<div class="input-group-prepend">
   							 	<span class="input-group-text">$</span>
    							<span class="input-group-text">0.00</span>
 							 </div>
					    <form:input maxlength="6" path="price" type="text" class="form-control" id="price" placeholder="Enter Price"/>
					    <small class="form-text text-muted"><form:errors path="price"/></small>
					 </div>
					 	<button type="submit" class="btn btn-primary">Submit</button>
				</form:form>
			</div>
		</div>
		<hr>
		<!-- jquery data table of users -->
		<table width="50%" border="1" id="users" class="display">
			<thead>
				<tr>
					<th width="25%">Email</th>
					<th width="25%">First Name</th>
					<th width="25%">Last Name</th>
					<th width="25%">Admin</th>
				</tr>
			</thead>
			<tbody></tbody>
		</table>
	</div>
	<br/><br/>
</body>
