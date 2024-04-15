<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.sql.*"%>
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
	margin-left: 45px;
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
	width: 87%;
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
<title>Login Page</title>

</head>
<body>

	<%  
	Class.forName("com.mysql.jdbc.Driver");
	int bookid=(Integer) session.getAttribute("bookid");
      String username=(String) session.getAttribute("username");
            String returndate=(String) session.getAttribute("returndate");
            System.out.println("====================");
            System.out.println(bookid);
            System.out.println(username);
            System.out.println(returndate);
            
      String todaydate=returndate;
            System.out.println(todaydate);
            
            if(returndate.equals(""))
			{
				RequestDispatcher rd=request.getRequestDispatcher("Unknownuser_returnbook.jsp");
				rd.forward(request, response);
			}
			
			String newRD=""; int rd=-1;
			if(!returndate.equals(""))
			{
				
			  newRD=returndate.substring(returndate.length()-2, returndate.length());
			  rd=Integer.parseInt(newRD);
			 
			}
			
			String newTD=todaydate.substring(todaydate.length()-2, todaydate.length());

			int td=Integer.parseInt(newTD);
			
			try{
			Class.forName("com.mysql.jdbc.Driver");
			if(returndate.equals(todaydate))
			{
				//managing books availability, issue
				Connection con2 = (Connection) DriverManager
						.getConnection("jdbc:mysql://localhost:3306/LibraryManagementSystem", "root", "root");
				PreparedStatement ps2 = con2.prepareStatement("select availability, issued from LibraryManagementSystem.Book where Book_Id=?;");
				
				ps2.setInt(1, bookid);
				ResultSet rs2 = ps2.executeQuery();
				int availability = -1, issued = -1;
				while (rs2.next()) {
					availability = rs2.getInt("availability");
					issued = rs2.getInt("issued");
				}
				int numofbooks=(Integer)session.getAttribute("numofbooks");
				
				while(1<=numofbooks) {
					availability++;
					issued--;
					numofbooks--;}
				PreparedStatement ps3 = con2.prepareStatement(
						"update LibraryManagementSystem.Book set availability=?, issued=? where Book_Id=?;");

				ps3.setInt(1, availability);
				ps3.setInt(2, issued);
				ps3.setInt(3, bookid);
				ps3.executeUpdate();
				
				
				//removing issued book from user book
				PreparedStatement ps4 = con2.prepareStatement(
						"delete from UserBookIssueTable."+username+"bookissuetable where return_date=?;");
			    
				ps4.setString(1, returndate);
				ps4.executeUpdate();
				
				//removing issued book from alluser book
				PreparedStatement ps5 = con2.prepareStatement(
						"delete from LibraryManagementSystem.AllBookIssueTable where return_date=?;");
			    
				ps5.setString(1, returndate);
				ps5.executeUpdate();
			}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
%>

	<div class="box">
		<div class="container">

			<div class="top-header">

				<header>Payment done Successfully.</header>
			</div>
			<form action="BookIssueTable.jsp" method="post">

				<div class="input-field">

					<input type="submit" class="submit" value="User Booklist">
				</div>
			</form>

			<div class="bottom"></div>

		</div>

	</div>

</body>
</html>