<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<body>
	<!-- bootstrap container -->
	<div class="container">
  		<div class="row">
    		<div class="col-sm-12 col-md-12 col-lg-12">
    			<!-- register user form -->
	    		<form:form method="POST" modelAttribute="user" action="registerUser" autocomplete="off" id="input_field">
	    		    <h2>Registration</h2>
					<div class="form-group">
						<label for="exampleInputEmail1">Email address</label>
					    <form:input maxlength="30" path="email" type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email"/>
					    <small class="form-text text-muted"><form:errors path="email"/></small>
					 </div>
					  <div class="form-group">
						<label for="first_name">First Name</label>
					    <form:input maxlength="20" path="firstName" type="text" class="form-control" id="first_name" placeholder="Enter First Name"/>
					    <small class="form-text text-muted"><form:errors path="firstName"/></small>
					 </div>
					  <div class="form-group">
						<label for="last_name">Last Name</label>
					    <form:input maxlength="20" path="lastName" type="text" class="form-control" id="last_name" placeholder="Enter Last Name"/>
					    <small class="form-text text-muted"><form:errors path="lastName"/></small>
					 </div>
					 <div class="form-group">
					    <label for="exampleInputPassword1">Password</label>
					   	<form:input maxlength="20" path="password" type="password" class="form-control" id="exampleInputPassword1" placeholder="Password"/>
					 	<small class="form-text text-muted"><form:errors path="password"/></small>
					 </div>
					  <button type="submit" class="btn btn-secondary">Register</button>
					<br/>
				</form:form>
			</div>
		</div>
	</div>
</body>
