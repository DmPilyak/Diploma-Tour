<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Login</title>
</head>
<body>
	<form action="login" method="post">
		<input name="email" type="text" placeholder="Your e-mail"/><br/>
		<input name="pass" type="password" placeholder="Your password"/><br/>
		<input type="submit" value="Login"/><br/>Or
	</form>
	<form action="signup">
		<input type="submit" value="Sign Up"/>
	</form>
	<form action="errorLog">
		<p style="color:#8B0000;">E-mail or password is incorrect! Try again</p>
	</form>
	
</body>
</html>