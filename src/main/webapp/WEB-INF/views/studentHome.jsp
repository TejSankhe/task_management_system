<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<div class="limiter">
		<span class="">
			<div class="">
				</b>ResNet</b></br> Northeastern University
		</span>
		<div class="">
		<a href="${contextPath}/addnewIssue">Add New Issue</a>
			<h3>Issues created by you are:</h3></br>
			<table class="table table-hover">
				<c:forEach items="${issues}" var="issue">
					<tr>
						<a href="${contextPath}/viewIssue?id=${issue.id}">Issue Name:
							${issue.issueName} Device: ${issue.device}</a>
					</tr></br>
				</c:forEach>
		</div>
	</div>
</body>
</html>