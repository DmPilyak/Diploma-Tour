<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="tour" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Tours</title>
</head>
<body>
	<table border="1">
		<tour:forEach items="${tourArray}" var="tour">
			<tr>
				<td><tour:out value="${tour.nameTour}" /></td>
				<td><tour:out value="${tour.description}" /></td>
				<td><tour:out value="${tour.price}" /></td>
				<td><form action="order" method="post">
					<button>Order tour</button>
				</form></td>
			<tr />
			<br />
		</tour:forEach>
	</table>
</body>
</html>