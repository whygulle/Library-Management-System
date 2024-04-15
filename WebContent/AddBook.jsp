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
<title>Add Book JSP</title>
</head>
<body>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
		crossorigin="anonymous"></script>
	<form action="AddBook" method="post">
		<h2>Add book you want</h2>
		<div class="mb-3">
			<label for="exampleInputPassword1" class="form-label">Book
				Name</label> <input type="text" class="form-control" name="name"
				id="exampleInputPassword1">
		</div>
		<div class="mb-3">
			<label for="exampleInputPassword1" class="form-label">Genre</label> <input
				type="text" class="form-control" name="genre"
				id="exampleInputPassword1">
		</div>
		<div class="mb-3">
			<label for="exampleInputPassword1" class="form-label">Author</label> <input
				type="text" class="form-control" name="author"
				id="exampleInputPassword1">
		</div>

		<button type="submit" class="btn btn-primary">Submit</button>
	</form>

</body>
</html>