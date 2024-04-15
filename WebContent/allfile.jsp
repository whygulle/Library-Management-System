<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Fiction page</title>

<style>
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}

body {
	background-color: #32312f;
	background-image: url('images/lib8.jpg');
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
	color: #f1f1f1;
	margin-bottom: 40px
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
	width: 100px;
	height: 40px;
	color: blacl;
	background-color: white;
	border: 1px solid;
	border-radius: 12px;
	margin-top: 10px;
	margin-left: 150px;
	font-size: 17px;
	font-family: sans-serif;
}
</style>
</head>
<body>
<%   String genre1=request.getParameter("name");
System.out.println(genre1); %>
	<div class="table-container">

		<h1 class="heading"> <%= genre1 %> books</h1>
		<table class="table">

			<thead>
				<tr>

					<th>Book Id</th>
					<th>Book Name</th>
					<th>Book Shell</th>
					<th>Author</th>
					<th>Release Date</th>
					<th>Availability</th>
					<th>Issued</th>
				</tr>

			</thead>
			<%
			
			 
				//String genre = "fictional";
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/LibraryManagementSystem", "root",
						"root");
				PreparedStatement ps = con.prepareStatement("select * from LibraryManagementSystem.Book where genre=? ;");

				ps.setString(1, genre1);
				ResultSet rs = ps.executeQuery();

				while (rs.next()) {
					int bookid = rs.getInt("Book_Id");
					String bookname = rs.getString("bookName");
					 int gid=rs.getInt("gid");
					String author = rs.getString("author");
					String releasedate = rs.getString("releasedate");
					int availability = rs.getInt("availability");
					int issued = rs.getInt("issued");
			%>

			<tbody>
				<tr>

					<td data-label="bookid"><%=bookid%></td>
					<td data-label="bookname"><%=bookname%></td>
					<td data-label="gid"><%=gid%></td>
					<td data-label="author"><%=author%></td>
					<td data-label="releasedate"><%=releasedate%></td>
					<td data-label="availability"><%=availability%></td>
					<td data-label="issued"><%=issued%></td>

				</tr>
			</tbody>
			<%
				}
			%>

		</table>
	</div>

	<div class="bookissuebtn">

		<form action="BookIssue.jsp">
			<input type="submit" value="Book Issue" name="bookissue">
		</form>
	</div>
</body>
</html>