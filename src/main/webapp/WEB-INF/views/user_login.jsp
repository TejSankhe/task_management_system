<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<spring:url value="/resources/css/main.css" var="mainCss" />
<spring:url value="/resources/images" var="images" />
    
<link href="${mainCss}" rel="stylesheet" />
</head>
<body>

<div class="wrapper fadeInDown">
  <div id="formContent">
    <!-- Tabs Titles -->

    <!-- Icon -->
    <div class="fadeIn first">
     
      <img src="${images}/login.jpg" id="icon" alt="User Icon" />
    </div>

    <!-- Login Form -->
<!--     <form>
    <input type="email" id="login" class="fadeIn second" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email">
      <input type="text" id="login" class="fadeIn second" name="login" placeholder="login">
      <input type="text" id="password" class="fadeIn third" name="login" placeholder="password">
      <input type="submit" class="fadeIn fourth" value="Log In">
    </form> -->
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<form:form action="${contextPath}/login"  commandName="user" method="post">
  <div class="form-group">
    <label for="exampleInputEmail1">Email address</label>
    <form:input path="emailId" type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email" required="required"/>
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Password</label>
    <form:input path="password" type="password" class="form-control" id="exampleInputPassword1" placeholder="Password" required="required"/>
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
</form:form>

    <!-- Remind Passowrd -->
    <div id="formFooter">
      <a class="underlineHover" href="${contextPath}/requestToAddProject">Not assigned to any project?</a>
    </div>

  </div>
</div>
</body>
</html>