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

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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
	background-color: rgba(255,255,255, 0.2);
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
	background: rgba(255, 255, 255, 0.2);
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
</style>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Page</title>

</head>
<body>

	<script type="text/javascript">
	
	alert('Welcome to login page')
	</script>

	<!--  <form action="LoginServlet" method="post">

		<div class="mb-3">
			<label for="exampleInputPassword1" class="form-label">Email</label> <input
				type="email" class="form-control" name="email" required
				id="exampleInputPassword1">
		</div>

		<div class="mb-3">
			<label for="exampleInputPassword1" class="form-label">Password</label>
			<input type="password" class="form-control" name="password" required
				id="exampleInputPassword1">
		</div>


		<button type="submit" class="btn btn-primary">Submit</button>
	</form>

  -->
	<div class="box">
		<div class="container">

			<div class="top-header">

				<header>Login</header>
			</div>
			<form action="LoginServlet" method="post">
				<div class="input-field">

					<input type="email" placeholder="Email" name="email" class="input"
						required>
				</div>

				<div class="input-field">
					<input type="password" placeholder="Password" class="input"
						name="password" required>
				</div>
				<div class="input-field">

					<input type="submit" class="submit" value="Login">
				</div>
			</form>
			<div class="bottom">
				
				<div class="right">
					<label><a href="forget.jsp">Forget password?</a></label>
				</div>
			</div>
		</div>
	</div>

</body>
</html>