<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Login V1</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<spring:url value="/resources/images/icons/favicon.ico" var="favicon" />
<spring:url value="/resources/images" var="images" />
<spring:url value="/resources/vendor/bootstrap/css/bootstrap.min.css"
	var="bootstrap" />
<spring:url
	value="/resources/fonts/font-awesome-4.7.0/css/font-awesome.min.css"
	var="fontawesome" />
<spring:url value="/resources/vendor/animate/animate.css" var="animate" />
<spring:url value="/resources/vendor/css-hamburgers/hamburgers.min.css"
	var="hamburger" />
<spring:url value="/resources/vendor/select2/select2.min.css"
	var="select2" />
<spring:url value="/resources/css/util.css" var="util" />
<spring:url value="/resources/css/main.css" var="main" />
<spring:url value="/resources/vendor/" var="vendor" />
<spring:url value="/resources/vendor/jquery/jquery-3.2.1.min.js"
	var="jquerymin" />
<spring:url value="/resources/vendor/bootstrap/js/popper.js"
	var="popper" />
<spring:url value="/resources/vendor/bootstrap/js/bootstrap.min.js"
	var="bootstrapJS" />
<spring:url value="/resources/vendor/select2/select2.min.js"
	var="select2JS" />
<spring:url value="/resources/vendor/tilt/tilt.jquery.min.js"
	var="tiltJS" />
<spring:url value="/resources/js/main.js" var="mainJS" />


<!--===============================================================================================-->
<link rel="icon" type="image/png" href="${favicon}" />
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="${bootstrap}">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="${fontawesome}">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="${animate}">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="${hamburger}">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="${select2}">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="${util}">
<link rel="stylesheet" type="text/css" href="${main}">
<!--===============================================================================================-->
</head>
<body>
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<div class="">
		<span class="">
			<div class="">
				</b>ResNet</b></br> Northeastern University
		</span>
		<div>
			<c:if test="${issue == null}">
				<h2>No issue found</h2>
			</c:if>
			<c:if test="${issue != null}">
				<br />
				<h3>
					<h3>Issue Details:</h3>
				</h3>
				<table class="table">
					<tr>
						<td>Issue Name</td>
						<td>${issue.issueName}</td>
					</tr>
					<tr>
						<td>Device</td>
						<td>${issue.device}</td>
					</tr>
					<tr>
						<td>Operating System</td>
						<td>${issue.operatingSystem}</td>
					</tr>
						<td>Problem</td>
						<td>${issue.problem}</td>
					<tr>
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
					</tr>
				</table>
			</c:if>
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