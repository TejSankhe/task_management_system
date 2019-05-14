<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<h1 class="display-5">Task Management System Northeastern
		University</h1>
	<a href="${contextPath}/logout" style="float: right;"
		class="btn btn btn-success btn-lg active" role="button"
		aria-pressed="true">Logout</a>
		<h1 class="display-6">Requests from user:</h1>
<table class="table">
		<thead>
			<tr>
				<th scope="col">Project Name</th>
				<th scope="col">Email Id</th>
				<th scope="col">Comment</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${requests}" var="request">
				<tr>
					<td>${request.projectname} </td>
					<td>${request.email} </td>
					<td>${request.comment}</td>
					<td><a href="${contextPath}/deleteRequest/${request.id}"
						class="btn btn btn-secondary btn-lg active" role="button"
						aria-pressed="true">Delete Request</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
			<%-- <table class="table table-hover">
			<c:forEach items="${requests}" var="request">
			Project Name:${request.projectname} Email Id: ${request.email} Comment 
			: ${request.comment}<a href="${contextPath}/deleteRequest/${request.id}">Delete Request</a>
					<tr>
						

							
					</tr></br>
				</c:forEach> 
				</table> --%>
</body>
</html>