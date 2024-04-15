<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Book page display</title>

<style type="text/css">
body {
	margin: 0;
	padding: 0;
	background-image: url('images/lib8.jpg');
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: 100% 100%;
}

h2 {
	margin-left:50px;
	text-align: center;
	color: white;
}

.List-of-category {
	margin-left: 430px;
	margin-top: 20px;
	width: 450px;
	height: 430px;
	background-color: gray;
	text-align: center;
}

ul {
	list-style-type: square;
}

li {
	font-size: 25px;
	list-style-type:none;
}

a {
	color: black;
	text-decoration: none;
}

a:hover {
	color: white;
}
</style>

</head>
<body>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
		crossorigin="anonymous"></script>

	<!-- 1nd attempt -->

	<!-- <table  class="table" background="images/lib8.jpg">


		<tr >

			<th>Book Id</th>
			<th>Book Name</th>
			<th>Genre</th>
			<th>Author</th>
			<th>Availability</th>
			<th>Issued</th>
		</tr>

		
			//Class.forName("com.mysql.jdbc.Driver");
			//Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/LibraryManagementSystem", "root",
	//				"root");
			//PreparedStatement ps = con.prepareStatement("select * from LibraryManagementSystem.Book; ");
			//ResultSet rs = ps.executeQuery();

			//while (rs.next()) {
			//	int bookId = rs.getInt("Book_Id");
				//		String bookName = rs.getString("bookName");
			//	String genre = rs.getString("genre");
				//String author = rs.getString("author");
				//	int availability=rs.getInt("availability");
			//	int issue=rs.getInt("issued");
		%>
		<tr >

			<td >=//bookId%></td>
			<td>=//bookName%></td>
			<td>=//genre%></td>
			<td>=//author%></td>
			<td>=//availability%></td>
			<td>=//issue%></td>

		</tr>

		//}	%>

	</table>
  -->

	<!-- 2nd attempt -->
	<!--  <h2>BOOKS UNDER THE LIBRARY</h2>	
	<div class="d-grid gap-2 d-md-block">

		<form action="Fiction.jsp">
			<button class="btn btn-info btn-lg">FICTIONAL</button>
		</form>

		<br>

		<form action="Selfhelp.jsp">
			<button class="btn btn-info btn-lg">SELF HELP</button>
		</form>
		<br>
		<form action="Autobiography.jsp">
			<button class="btn btn-info btn-lg">AUTO BIOGRAPHY</button>
		</form>
		<br>
		<form action="Bsc.jsp">
			<button class="btn btn-info btn-lg">FINANCE</button>
		</form>

		<br>
		<form action="Bsc.jsp">
			<button class="btn btn-info btn-lg">SCIENCE AND KNOWLEDGE</button>
		</form>
		<br>
		<form action="Shortstory.jsp">
			<button class="btn btn-info btn-lg">SHORT STORY</button>
		</form>
		<br>
		<form action="Nonfictional.jsp">
			<button class="btn btn-info btn-lg">NON FICTIONAL</button>
		</form>
		<br>
		<form action="Bsc.jsp">
			<button class="btn btn-info btn-lg">COMICS</button>
		</form>
		<br>

		<form action="Bsc.jsp">
			<button class="btn btn-info btn-lg">SPIRITUAL AND WISDOM</button>
		</form>
		<br>

		<form action="Bsc.jsp">
			<button class="btn btn-info btn-lg">REFERENCE BOOKS</button>
		</form>
		<br>
		<form action="Bsc.jsp">
			<button class="btn btn-info btn-lg">POETRY</button>
		</form>

	</div> -->

	<h2>List of Category</h2>
	<section class="List-of-category">
	<ul>
		<li><a href="allfile.jsp?name=fictional">FICTIONAL</a></li>
		<li><a href="allfile.jsp?name=self help">SELF HELP</a></li>
		<li><a href="allfile.jsp?name=auto biography">AUTO BIOGRAPHY</a></li>
		<li><a href="allfile.jsp?name=finance">FINANCE</a></li>
		<li><a href="allfile.jsp?name=science">SCIENCE AND KNOWLEDGE</a></li>
		<li><a href="allfile.jsp?name=short story">SHORT STORY</a></li>
		<li><a href="allfile.jsp?name=non fictional">NON FICTIONAL</a></li>
		<li><a href="allfile.jsp?name=comic">COMICS</a></li>
		<li><a href="allfile.jsp?name=spiritual">SPIRITUAL AND WISDOM</a></li>
		<li><a href="Referencebook.jsp">REFERENCE BOOKS</a></li>
		<li><a href="allfile.jsp?name=poetry">POETRY </a></li>
		<!-- Add more links for other sections as needed -->
	</ul>
	</section>

</body>
</html>