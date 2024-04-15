<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Alluser book issue table</title>


<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">

<style>
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}

body {
	background-color: #32312f;
	background-image: url('images/lib3.jpg');
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: 100% 100%;
	font-family: sans-serif;
}

.table-container {
	padding: 0 10%;
	margin: 40px auto 0;
}

.heading {
	font-size: 40px;
	text-align: center;
	color: black;
	background-color: white;
	margin-bottom: 30px;
	margin-left: 260px;
	width: 500px;
}

.table {
	width: 100%;
	border-collapse: collapse;
}

.table thead {
	background-color: white;
}

.table thead tr th {
	font-size: 22px;
	font-weight: 600;
	letter-spacing: 0.35px;
	color: black;
	text-align: center;
	opacity: 1;
	pdding: 12px;
	vertical-align: top;
	border: 1px solid #dee2e685;
}

.table tbody tr td {
	font-size: 20px;
	letter-spacing: 0.35px;
	font-weight: normal;
	color: #f1f1f1;
	background-color: #3c3f44;
	padding: 8px;
	text-align: center;
	border: 1px solid #dee2e685;
}

.bookissuebtn input {
	width: 120px;
	height: 40px;
	color: blacl;
	background-color: white;
	border: 1px solid;
	border-radius: 12px;
	margin-top: 5px;
	margin-left: 150px;
	font-size: 17px;
	font-family: sans-serif;
}
</style>
</head>
<body>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
		crossorigin="anonymous"></script>


	<div class="table-container">

		<h1 class="heading">Alluser Book Issue Table</h1>
		<table class="table">
			<thead>
				<tr>

					<th>Book Id</th>
					<th>Book Name</th>
					<th>User Email</th>
					<th>Genre </th>
					<th>Issue Date</th>
					<th>Return Date</th>

				</tr>
			</thead>
			<%
				
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/UserBookIssueTable", "root",
						"root");
				PreparedStatement ps = con
						.prepareStatement("select * from LibraryManagementSystem.AllBookIssueTable;");
				ResultSet rs = ps.executeQuery();

				while (rs.next()) {
					int bookid = rs.getInt("bookid");
					String bookname = rs.getString("bookname");
					String useremail = rs.getString("useremail");
					String genre = rs.getString("genre");
					String issuedate = rs.getString("issue_date");
					String returndate = rs.getString("return_date");
			%>
			<tbody>
				<tr>
					<td><%=bookid%></td>
					<td><%=bookname%></td>
					<td><%=useremail%></td>
					<td><%=genre%></td>
					<td><%=issuedate%></td>
					<td><%=returndate%></td>
				</tr>
			</tbody>
			<%
				}
			%>
		</table>

	</div>
	<div class="bookissuebtn">

		<form action="index.jsp">
			<input type="submit" value="Home page" name="bookissue">
		</form>
	</div>

</body>
</html>