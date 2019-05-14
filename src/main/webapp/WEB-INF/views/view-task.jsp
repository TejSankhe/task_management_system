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
<title>Task</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<h1 class="display-5">Task Management System Northeastern
		University</h1>
	<a href="${contextPath}/logout" style="float: right;"
		class="btn btn btn-success btn-lg active" role="button"
		aria-pressed="true">Logout</a>
	<br>
		<div>
			<c:if test="${task == null}">
				<h2>No task found</h2>
			</c:if>
			<c:if test="${task != null}">
				<br />
				<h3>
					<h3>Task Details:</h3>
				</h3>
				<table class="table">
					<tr>
						<td>Task Name</td>
						<td>${task.name}</td>
					</tr>
					<tr>
						<td>Description</td>
						<td>${task.description}</td>
					</tr>
					<tr>
						<td>Project</td>
						<td>${task.project.name}</td>
					</tr>
					<tr>
						<td>Assigned To</td>
						<td>${task.assignedTo.emailId}</td>
					</tr>
					<%-- <tr>
						<td>Is Registered</td>
						<td>${issue.isRegistered}</td>
					</tr>
					<tr>
						<td>Registration Id</td>
						<td>${issue.registrationId}</td>
					</tr>
					<tr>
						<td>Solution</td>
						<td>${issue.solution}</td>
					</tr>
					<tr>
						<td>Cost</td>
						<td>${issue.cost}</td>
					</tr>
					<tr>
						<td>Status</td>
						<td>${issue.status}</td>
					</tr>
					<tr>
						<td>Technician</td>
						<td>${issue.technician.name}</td>
					</tr>	
					<tr>
						<td>Student</td>
						<td>${issue.student.name}</td>	
					</tr> --%>
				</table>
			</c:if>
		</div>
		<a href="${contextPath}/pdfviewoftask?id=${task.id}" class="btn btn btn-primary btn-lg active" role="button"
		aria-pressed="true">Get PDF View</a>
</body>
</html>