<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<style>
body {
	font-family: Arial, sans-serif;
	margin: 0;
	padding: 0;
	background-image: url('images/lib6.jpg');
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: 100% 100%;
}

header {
	background-color: #333;
	color: #fff;
	padding: 10px;
	text-align: center;
}

.welcome-section {
	max-width: 800px;
	margin: 20px auto;
	padding: 20px;
	background-color: #fff;
	border-radius: 8px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

.navigation-section {
	max-width: 800px;
	margin: 20px auto;
	padding: 20px;
	background-color: #fff;
	border-radius: 8px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

ul {
	list-style-type: none;
	padding: 0;
}

li {
	margin-bottom: 10px;
}

ul a {
	color: #333;
	font-weight: bold;
	transition: color 0.3s ease;
	text-decoration: none;
}

a:hover {
	color: #0066cc;
}

.navigation-section button {
	border-radius: 10px;
	background-color: black;
	color: #f1f1f1;
}
</style>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home page</title>
</head>
<body>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
		crossorigin="anonymous"></script>

	<%  
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	       
	      session=request.getSession();
		
		if(session.getAttribute("username")==null){
		  	
			response.sendRedirect("Login.jsp");
		}%>


	<!-- 	<nav class="navbar navbar-expand-lg bg-body-tertiary">
	<div class="container-fluid">
		<a class="navbar-brand" href="#">WELCOME TO E-LIBRARY</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="BookPage.jsp">View Books</a></li>
					
					<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="BookIssueTable.jsp">My Books</a></li>
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="AddBook.jsp">Add Book</a></li>
					
					<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="BookIssue.jsp">Issue Book</a></li>
					
					<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="Logout.jsp">Log out</a></li>
				
			</ul>
		</div>
	</div>
	</nav> <img src="images/lib6.jpg" alt="Loading" width="1290px" height="550px">
	  -->
     <% String username=(String) session.getAttribute("username"); %>

	<header>
	<h1>Library Management System</h1>
	</header>

	<section class="welcome-section">
	<h2>Welcome to the Library <%= username %>!</h2>
	<!-- Explore our collection of books and manage your reading experience. -->
	<p>Explore the collection of books and manage your reading
		experience.</p>
	</section>

	<section class="navigation-section">
	<h2>Quick Access</h2>
	<ul>
		<li><a href="BookPage.jsp">View Books</a></li>
		<li><a href="BookIssue.jsp">Issue Book</a></li>
		<li><a href="BookIssueTable.jsp">User Booklist</a></li>
		<li><a href="Alluserbookissuetable.jsp">Alluser Booklist</a></li>
		<li><a href="Returnbook.jsp">Return Book</a></li>
		<button>
			<a href="Logout.jsp">Log Out</a>
		</button>
		<!-- Add more links for other sections as needed -->
	</ul>
	</section>
</body>
</html>