<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
   
<body>
<!-- bootstrap navbar -->
<nav class="navbar navbar-expand-lg navbar-light bg-light">
<!-- nav to launch page -->
  <a class="navbar-brand" href="${pageContext.servletContext.contextPath}/">
  	<img src="${pageContext.request.contextPath}/resources/images/logo.png" width="30" height="30" class="d-inline-block align-top" alt="">
  	SJ Shoes
  </a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item">
      	<!-- if not admin -->
      	<c:if test="${user.getAdmin() == NULL || user.getAdmin() == 0}">
      		<!-- nav user home -->
      		<a class="nav-link" href="${pageContext.servletContext.contextPath}/home" id="boot_nav">Home <span class="sr-only">(current)</span></a>
      	</c:if>
      	<!-- if admin -->
      	<c:if test="${user.getAdmin() == 1}">
      		<!-- nav admin home -->
      		<a class="nav-link" href="${pageContext.servletContext.contextPath}/shoe/add" id="boot_nav">Home <span class="sr-only">(current)</span></a>
      	</c:if>
      </li>
      <li class="nav-item">
      	<!-- nav to shoe  view -->
        <a class="nav-link" href="${pageContext.servletContext.contextPath}/shoe/view" id="boot_nav">Shoes</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="${pageContext.servletContext.contextPath}/contact" id="boot_nav">Contact Us</a>
      </li> 
    </ul>
    <ul class="navbar-nav">
    <li class="nav-item">
      <!-- if user is guest or not logged in -->
      	<c:if test="${user.getId() == NULL || user.getId() == 0}">
      		<a class="nav-link" href="${pageContext.servletContext.contextPath}/user/login" id="boot_nav">Login/Sign-up</a>
      	</c:if>
      	<!-- if user is logged in -->
      	<c:if test="${user.getId() > 0}">
      		<a class="nav-link" href="${pageContext.servletContext.contextPath}/user/login" id="boot_nav">Logout</a> 
      	</c:if>
      </li>
    </ul>
  </div>
</nav>
</body>