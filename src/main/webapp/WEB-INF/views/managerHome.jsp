<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<title>Login</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<c:set var="manager" value="${manager}" />
	<h1 class="display-5">Task Management System Northeastern
		University</h1>
	<a href="${contextPath}/logout" style="float: right;"
		class="btn btn btn-success btn-lg active" role="button"
		aria-pressed="true">Logout</a>
	<h1 class="display-7">Project Name: ${manager.project.name}</h1>
	<br>
	<h1 class="display-6">Task Assigned to you are:</h1>
	<a href="${contextPath}/addnewTask"
		class="btn btn btn-primary btn-lg active" role="button"
		aria-pressed="true">Add New Task</a>

	<table class="table">
		<thead>
			<tr>
				<th scope="col">Task Name</th>
				<th scope="col">Task Description</th>
				<th scope="col">View</th>
				<th scope="col">Update</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${manager.tasks}" var="task">
				<tr>
					<td>${task.name}</td>
					<td>${task.description}</td>
					<td><a href="${contextPath}/viewTask?id=${task.id}"
						class="btn btn btn-secondary btn-lg active" role="button"
						aria-pressed="true">View Task</a></td>
					<td><a href="${contextPath}/updateTask?id=${task.id}"
						class="btn btn btn-secondary btn-lg active" role="button"
						aria-pressed="true">Update Task</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<%-- <table class="table table-hover">
			<c:forEach items="${manager.tasks}" var="task">
					<tr>
						Task Name:
							${task.name} Task Description: ${task.description} Task Assigned To: ${task.assignedTo.emailId}
							<a href="${contextPath}/viewTask?id=${task.id}">View Task</a>
							<a href="${contextPath}/updateTask?id=${task.id}">Update Task</a>
					</tr></br>
				</c:forEach> 
				</table> --%>
</body>
</html>