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

					<h3 class="display-6">Mail admin the request:</h3>
				<form:form accept-charset="UTF-8" action="${contextPath}/requestToAddProject" commandName="userrequest" method="post">	
				<table class="table">
					<tr>
						<td>Project Name:</td>
							<td><form:input  class="span3"  path="projectname" size="30" required="required" />
					</tr>
					<tr>
						<td>Comment</td>
						<td><form:input  class="span3"  path="comment" size="30"/>
					</tr>
					<tr>
						<td>Email ID</td>
						<td><form:input type="email" class="span3"  path="email" size="30" required="required" />
					<font color="red"></font></td>
					<tr>
			<td colspan="2"> <button class="btn btn-warning" type="submit">Submit Request</button></td>
				
			</tr>
				</table>
			  </form:form>
</body>
</html>