<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<body>
	<!-- bootstrap container -->
	<div class="container">
  		<div class="row">
    		<div class="col-sm-12 col-md-12 col-lg-12">
    			<!-- login user form -->
	    		<form:form method="POST" modelAttribute="user" action="loginUser" autocomplete="off" id="input_field">
	    		    <h2>Login</h2>
					<div class="form-group">
						<!-- email address label and input -->
						<label for="exampleInputEmail1">Email address</label>
					    <form:input maxlength="30" path="email" type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email"/>
					    <small class="form-text text-muted"><form:errors path="email"/></small>
					 </div>
					 <div class="form-group">
					 	<!-- password label and input -->
					    <label for="exampleInputPassword1">Password</label>
					   	<form:input maxlength="20" path="password" type="password" class="form-control" id="exampleInputPassword1" placeholder="Password"/>
					 	<small class="form-text text-muted"><form:errors path="password"/></small>
					 </div>
					  <button type="submit" class="btn btn-secondary">Login</button>
					<br/>
				</form:form>
			</div>
		</div>
		<!-- display error message -->
		<h1>${error}</h1>
		<div class="row justify-content-sm-center justify-content-md-center justify-content-lg-center">
			<div class="col-sm-auto col-md-auto col-lg-auto">
				Don't have an account? 
				<!-- navigate to register page -->
				<a href="${pageContext.request.contextPath}/user/register">Register</a>
			</div>
		</div>
	</div>
</body>
