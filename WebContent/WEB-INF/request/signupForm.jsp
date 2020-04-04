<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Sign Up</title>
</head>
<body>
	<form action="signup" method ="POST">
		Name	<input name="name" type="text" placeholder="Your name"/><br/>
		Surname	<input name="surname" type="text" placeholder="Your surname"/><br/>
		E-mail	<input name="userEmail" type="text" placeholder="Your e-mail"/><br/>
		Password<input name="pass" type="password" placeholder="Your password"/><br/>
		Date of Birth<input name="birthday" type="date" placeholder="Your birthday"/><br/>
		Gender<br/>
		<input name="gender" type="radio" value="male"/> Male
		<br/>
		<input name="gender" type="radio" value="female"/> Female
		<br/>
		<input type="submit" value="Sign up"/>
	</form>
</body>
</html>