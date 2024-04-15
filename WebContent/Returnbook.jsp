<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.sql.*"%>

<%@ include file="Bootstrap.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Return book</title>

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
	margin-top: 70px;
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
	color: #fff;
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
	background: rgba(255, 255, 255, 0.9);
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

.submit-login {
	border: none;
	border-radius: 10px;
	font-size: 15px;
	height: 30px;
	outline: none;
	width: 100%;
	background: rgba(255, 255, 255, 0.7);
	cursor: pointer;
	transition: .3s;
}

.submit-login:hover {
	box-shadow: 1px 5px 7px 1px rgba(0, 0, 0, 0.2);
}
</style>
</head>
<body>


	<!-- <h3>Return Book</h3>
	<section class="ReturnBook">
		<form action="ReturnBook" method="post">

			<div class="mb-3">
				<label for="exampleInputEmail1" class="form-label">Book Id</label> <input
					type="number" class="form-control" name="id"
					id="exampleInputEmail1" required aria-describedby="emailHelp">
				<div id="emailHelp" class="form-text"></div>
			</div>

			<div class="mb-3">
				<label for="exampleInputPassword1" class="form-label">Today's 
					Date </label> <input type="date" class="form-control" name="todaydate"
					required id="exampleInputPassword1">
			</div>
			<br>
			<button class="btn btn-primary">Submit</button>
		</form>
	</section> -->

	<div class="box">
		<div class="container">

			<div class="top-header">

				<header>Return Book</header>
			</div>
			<form action="ReturnBook" method="post">
				<div class="input-field">

					<input type="number" placeholder="Book Id" name="id" class="input"
						required>
				</div>



				<div class="input-field">
					<input type="date" placeholder="Todays date" class="input"
						name="todaydate" required>
				</div>

				<div class="input-field">

					<input type="submit" class="submit" value="Submit">
				</div>
			</form>

		</div>
	</div>

</body>
</html>