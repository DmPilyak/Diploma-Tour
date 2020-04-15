
	function validateEmailAndPassword() {
		var userEmail = $("#email").val();
		var userPassword = $("#pass").val();
		var emailField = document.getElementById("email");
		var passField = document.getElementById("pass");
		var emailValid = false;
		for (var i = 0; i < userEmail.length; i++) {
			if (userEmail[i] == '@') {
				emailValid = true;
			}
			if (userEmail[i] == ' '){
				emailValid = false;
				break;
			}
		}
		var passValid = false;
		if (userPassword.length > 4) {
			passValid = true;
			for (var i = 0; i < userPassword.length; i++) {
				if (userPassword[i] == ' ')
					passValid = false;
				break;
			}
		}

		if (userEmail.length == 0 || !emailValid) {
			emailField.style.border = "1.5px solid red";
			return false;
		} else
			emailField.style.border = "none";

		if (userPassword.length == 0 && !passValid) {
			passField.style.border = "1.5px solid red";
			return false;
		} else
			passField.style.border = "none";
		return true;
	}
	
	function validateNameAndSurname(){
		validateEmailAndPassword();
		var userEmail = $("#email").val();
		var userPassword = $("#pass").val();
		var emailField = document.getElementById("email");
		var passField = document.getElementById("pass");
	}
		
	
	

