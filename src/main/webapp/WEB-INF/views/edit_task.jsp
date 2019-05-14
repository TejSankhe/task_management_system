<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
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
		<br />
		<h3>
			<h3>Edit Task:</h3>
		</h3>
		<form:form accept-charset="UTF-8"
			action="${contextPath}/updatedTask?id=${updatedTask.id}"
			commandName="updatedTask" method="post">
			<table class="table">
				<tr>
					<td>Task Name:</td>
					<td><form:input class="span3" path="name" size="30"
							required="required" /> <font color="red"><form:errors
								path="name" /></font></td>
				</tr>
				<tr>
					<td>Description</td>
					<td><form:input class="span3" path="description" size="30" />
				</tr>
				<tr>
					<td>Task Severity</td>
					<td><form:input class="span3" path="taskSeverity" size="30"
							required="required" /> <font color="red"><form:errors
								path="taskSeverity" /></font></td>
				</tr>
				<tr>
					<td>Task Status</td>
					<td><form:input class="span3" path="taskStatus" size="30"
							required="required" /> <font color="red"><form:errors
								path="taskStatus" /></font></td>
				</tr>
				<tr>
					<td>Assign To</td>
					<td><input type="email" class="span3" name="assignedTouser"
						size="30" required="required"
						value="${updatedTask.assignedTo.emailId}" /> <font color="red"></font></td>
				<tr>
					<td colspan="2">
						<button class="btn btn-warning" type="submit">Update Task</button>
					</td>

				</tr>
				</tr>
			</table>
		</form:form>
	</div>
	</div>


	</div>
</body>
</html>