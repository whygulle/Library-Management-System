<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User page</title>

<style>
* {
	margin: 0;
	padding: 0;
	font-family: 'Arial', Helvetica, sans-serif;
}

body {
	background-image: url('images/lib8.jpg');
	background-size: cover;
	background-repeat: no repeat;
	background-position: center;
	background-attachment: fixed;
}

.box {
	display: flex;
	justify-content: center;
	align-items: center;
	min-hieght: 90vh;
}

.container {
	width: 350px;
	display: flex;
	margin-top: 100px;
	flex-direction: column;
	padding: 0 15px 0 15px;
}

span {
	color: #fff;
	font-size: 15px;
	display: flex;
	justify-content: center;
	padding: 10px 0 10px 0;
}

header {
	color: black;
	background-color: rgba(255,255,255, 0.1);
	font-size: 30px;
	display: flex;
	margin-right: 25px;
	justify-content: center;
	padding: 10px 0 10px 0;
}

.input-field {
	display: flex;
	flex-direction: column;
}

.input {
	width: 87%;
	height: 45px;
	border: none;
	outline: none;
	border-radius: 30px;
	color: white;
	padding: 0 0 0 42px;
	background: rgba(255, 255, 255, 0.1);
	margin-top: 25px;
}

i {
	position: relative;
	top: -31px;
	left: 17px;
	color: #fff;
}

::-webkit-input-placeholder {
	color: white;
}

.submit {
	border: none;
	border-radius: 30px;
	font-size: 15px;
	height: 43px;
	outline: none;
	width: 87%;
	background: rgba(255, 255, 255, 0.7);
	cursor: pointer;
	transition: .3s;
	margin-top: 25px;
}

.submit:hover {
	box-shadow: 1px 5px 7px 1px rgba(0, 0, 0, 0.2);
}

.bottom {
	display: flex;
	flex-direction: row;
	justify-content: space-between;
	font-size: small;
	color: #fff;
	margin-top: 10px;
}

.left {
	display: flex;
	font-size: 15px;
}

label a {
	color: #fff;
	margin-right: 25px;
	font-size: 17px;
	text-decoration: none;
}

.submit-login{
 border: none;
	border-radius: 10px;
	font-size: 15px;
	height: 30px;
	outline: none;
	width: 70px;
	background: rgba(255, 255, 255, 0.7);
	cursor: pointer;
	transition: .3s;
	
}

.submit-login:hover {
	box-shadow: 1px 5px 7px 1px rgba(0, 0, 0, 0.2);
}

p{
 
 display:none;
 color:red;

}
</style>
</head>
<body>

	<!--  background-image: url('images/lib5.jpg');
  background-repeat: no-repeat;
  background-attachment: fixed; 
  background-size: 100% 100%; -->

	

	<!-- 		<h2>User form</h2>
	<form action="UserServlet" method="post">
		
		<div class="mb-3">
			<label for="exampleInputPassword1" class="form-label">User
				Name</label> <input type="text" class="form-control" name="name"
				id="exampleInputPassword1" required>
		</div>
		
		<div class="mb-3">
			<label for="exampleInputPassword1" class="form-label">Email</label> <input type="email" class="form-control" name="email"
				id="exampleInputPassword1" required>
		</div>
		
		<div class="mb-3">
			<label for="exampleInputPassword1" class="form-label">Password</label> <input
				type="password" class="form-control" name="password" required
				id="exampleInputPassword1">
		</div>
		<div class="mb-3">
			<label for="exampleInputPassword1" class="form-label">Confirm Password</label> <input
				type="password" class="form-control" name="cnfpassword" required
				id="exampleInputPassword1">
		</div>

		<button type="submit" class="btn btn-primary">Create</button>
	</form>
	<br>
	<form action="Login.jsp"> <button type="submit" class="btn btn-primary">Old User</button></form>
	 -->

	<div class="box">
		<div class="container">

			<div class="top-header">

				<header>Register</header>
			</div>
			<form action="UserServlet" method="post">
				<div class="input-field">

					<input type="text" placeholder="User name" name="name" class="input"
						required>
				</div>

				<div class="input-field">

					<input type="email" placeholder="Email" name="email" class="input"
						required>
				</div>

				<div class="input-field">
					<input type="password" placeholder="Password" name="password"
					id="pass" class="input" required onchange="checkpass()">
                    <p class="error-msg">must contain at lease 8 characters</p>
				</div>

				<div class="input-field">
					<input type="password" placeholder="Confirm password" class="input"
					id="cnfpassword"	name="cnfpassword" required  disabled=true onchange="passwordmatch()">
				 <p class="error-msg2">Password is not matching</p>
				</div>

				<div class="input-field">

					<input type="submit" class="submit" value="Submit"  >
				</div>
			</form>

			<div class="bottom">

				<div class="left">
					<form action="Login.jsp">
						<input type="submit" class="submit-login" value="Old user">
					</form>
				</div>

			</div>

		</div>

	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
		crossorigin="anonymous">
	
	</script>
	
	<script> var reg=/^[a-z0-9\@]{8}$/
	
		var errorMsg=document.querySelector('.error-msg');
	const pass2=document.getElementById('cnfpassword');
	function checkpass()
	{
		const pass=document.getElementById('pass').value;
		var isValid=reg.test(pass);
		
		if(isValid)
			{
			errorMsg.style.display='none'
			}
		else{
			
			errorMsg.style.display='block'
				pass2.disabled=false;
		}
		
	}
	
	var errorMsg2=document.querySelector('.error-msg2');
	function passwordmatch(){
		
		const pass=document.getElementById('pass').value;
		const pass2=document.getElementById('cnfpassword').value;
		
		if(pass===pass2)
			{
			errorMsg2.style.display='none'
			}
		else{
			errorMsg2.style.display='block'
		}
	}
	
	</script>
</body>
</html>