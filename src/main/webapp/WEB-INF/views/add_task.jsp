<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<head>
</head>
<body>
	<div class="">
		<span class="">
			<div class="">
		</span>
		<div>
				<br />
				<h3>
					<h3>Create an Task:</h3>
				</h3>
				<form:form accept-charset="UTF-8" action="/addnewTask" commandName="task" method="post">	
				<table class="table">
					<tr>
						<td>Task Name:</td>
							<td><form:input  class="span3"  path="name" size="30" required="required" />
					<font color="red"><form:errors path="name" /></font></td>
					</tr>
					<tr>
						<td>Description</td>
						<td><form:input  class="span3"  path="description" size="30" required="required"/>
					<font color="red"><form:errors path="description" /></font></td>
					</tr>
					<tr>
						<td>Operating System</td>
						<td><form:input  class="span3"  path="operatingSystem" size="30" />
					<font color="red"><form:errors path="operatingSystem" /></font></td>
					</tr>
						<td>Problem</td>
						<td><form:input  class="span3"  path="problem" size="30" required="required" />
					<font color="red"><form:errors path="problem" /></font></td>
					<tr>
						<td>Is Registered</td>
						<td><form:input  class="span3"  path="isRegistered" size="30"/>
					<font color="red"><form:errors path="isRegistered" /></font></td>
					</tr>
					<tr>
						<td>Registration Id</td>
						<td><form:input  class="span3"  path="registrationId" size="30"/>
					<font color="red"><form:errors path="registrationId" /></font></td>
					</tr>
					<tr>
			<td colspan="2"> <button class="btn btn-warning" type="submit">Add Car</button></td>
				
			</tr>
					</tr>
				</table>
			  </form:form>
		</div>
	</div>


	</div>



	<!--===============================================================================================-->
	<script src="${jquerymin}"></script>
	<!--===============================================================================================-->
	<script src="${popper}"></script>
	<script src="${bootstrapJS}"></script>
	<!--===============================================================================================-->
	<script src="${select2JS}"></script>
	<!--===============================================================================================-->
	<script src="${tiltJS}"></script>
	<script>
		$('.js-tilt').tilt({
			scale : 1.1
		})
	</script>
	<!--===============================================================================================-->
	<script src="${mainJS}"></script>

</body>
</html>