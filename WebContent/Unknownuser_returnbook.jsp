<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


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
	color: Black;
	font-size: 30px;
	display: flex;
	margin-right: 50px;
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
	color: black;
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
	color: black;
}

.submit {
	border: none;
	border-radius: 30px;
	font-size: 15px;
	height: 43px;
	outline: none;
	width: 70%;
	background: rgba(255, 255, 255, 0.7);
	cursor: pointer;
	transition: .3s;
	margin-top: 25px;
}

.submit:hover {
	box-shadow: 1px 5px 7px 1px rgba(0, 0, 0, 0.2);
}


</style>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Unknown user Page</title>

</head>
<body>



	<div class="box">
		<div class="container">

			<div class="top-header">

				<header>You are not allowed to return another user returnbook </header>
			</div>
			<form action="index.jsp" method="post">

				<div class="input-field">

					<input type="submit" class="submit" value="Home Page">
				</div>
			</form>

			<div class="bottom"></div>

		</div>

	</div>

</body>
</html>