<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="ValidationJS.js"></script>

<title>Sign up</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="icon" type="image/png" href="images/icons/favicon.ico" />
<link rel="stylesheet" type="text/css"
	href="vendor/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css"
	href="fonts/iconic/css/material-design-iconic-font.min.css">
<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
<link rel="stylesheet" type="text/css"
	href="vendor/css-hamburgers/hamburgers.min.css">
<link rel="stylesheet" type="text/css"
	href="vendor/animsition/css/animsition.min.css">
<link rel="stylesheet" type="text/css"
	href="vendor/select2/select2.min.css">
<link rel="stylesheet" type="text/css"
	href="vendor/daterangepicker/daterangepicker.css">
<link rel="stylesheet" type="text/css" href="css/util.css">
<link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body>

	<div class="limiter">
		<div class="container-login100"
			style="background-image: url('images/bg-01.jpg');">
			<div class="wrap-login100">
				<form action="signup" method="post"
					class="login100-form" onsubmit="return validateEmailAndPassword();">
					<span class="login100-form-logo"> <i
						class="zmdi zmdi-landscape"></i>
					</span> <span class="login100-form-title p-b-34 p-t-27"> Sign up </span>

					<div class="wrap-input100"
						data-validate="Enter name">

						<input id="name" class="input100" type="text" name="name"
							placeholder="Your name"> <span class="focus-input100"
							data-placeholder="&#xf207;"></span>
					</div>

					<div class="wrap-input100"
						data-validate="Enter surname">
						<input id="surname" class="input100" type="text" name="surname"
							placeholder="Your surname"> <span class="focus-input100"
							data-placeholder="&#xf207;"></span>
					</div>

					<div class="wrap-input100"
						data-validate="Enter e-mail">
						<input id="email" class="input100" type="text" name="email"
							placeholder="E-mail"> <span class="focus-input100"
							data-placeholder="&#xf324;"></span>
					</div>

					<div class="wrap-input100"
						data-validate="Enter password">
						<input id="pass" class="input100" type="password" name="pass"
							placeholder="Password"> <span class="focus-input100"
							data-placeholder="&#xf191;"></span>
					</div>

					<div class="wrap-input100"
						data-validate="Enter birthday">
						<input class="input100" type="date" name="birthday"
							placeholder="Birthday"> <span class="focus-input100"
							data-placeholder="&#xf332;"></span>
					</div>

					<div class="wrap-input100"
						data-validate="Enter birthday">
						<input class="input100" type="radio" name="gender" value="male">
						<span class="focus-input100" data-placeholder="&#xf211;"></span>Male
						<input class="input100" type="radio" name="gender" value="female">
						<span class="focus-input100"></span>Female
					</div>
					
					<div class="container-login100-form-btn">
						<button class="login100-form-btn">Sign up</button>
					</div>
				</form>
			</div>
		</div>
	</div>


	<div id="dropDownSelect1"></div>

</body>
</html>