<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Your profile</title>
</head>
<body>
	<p>Your user is: ${logUser.firstName}</p>
	<form action="logout">
		<input type="submit" value="Logout"/>
	</form>
	<form action="toursList">
		<input type="submit" value="Order tours"/>
	</form>
	
</body>
</html>