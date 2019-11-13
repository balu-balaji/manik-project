<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>

<!-- Access the bootstrap Css like this, 
		Spring boot will handle the resource mapping automcatically -->
<link rel="stylesheet" type="text/css"
	href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />

<!-- 
	<spring:url value="/css/main.css" var="springCss" />
	<link href="${springCss}" rel="stylesheet" />
	 -->
<c:url value="/css/main.css" var="jstlCss" />
<c:url value="/js/main.js" var="jstlJs" />
<link href="${jstlCss}" rel="stylesheet" />

</head>
<body>
	<%@ include file="nav.html"%>
	<div class="container">
		<div class="starter-template">
			<h1>Spring Boot Web JSP Example</h1>
			<h2>Person Information: ${message}</h2>
		</div>
		<table>
			<c:forEach items="${persons}" var="person">
				<tr>
					<td>${person.id}</td>
					<td>${person.name}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>

<script type="text/javascript"
	src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${jstlJs}"></script>

</html>