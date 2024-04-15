package Com.ServletPackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Connection;

@WebServlet("/ReturnBook")
public class ReturnBook extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// taking input from the user
		int bookid = Integer.parseInt(request.getParameter("id"));
		String todaydate = request.getParameter("todaydate");

		// making bookid and todaydate to session to use in pay.jsp page!
		HttpSession session = request.getSession();
		session.setAttribute("bookid", bookid);
		session.setAttribute("todaydate", todaydate);

		String username = (String) session.getAttribute("username");
		try {

			PrintWriter out = response.getWriter();

			// fetching returndate from database to verifying
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/UserBookIssueTable",
					"root", "root");
			PreparedStatement ps = con.prepareStatement(
					"select return_date from UserBookIssueTable." + username + "bookissuetable where bookid=? ");
			ps.setInt(1, bookid);
			ResultSet rs = ps.executeQuery();
			String returndate = "";

			while (rs.next()) {

				returndate = rs.getString("return_date");
				if (returndate.equals(todaydate)) {
					break;
				}
			}

			session.setAttribute("returndate", returndate);
			System.out.println(todaydate);
			System.out.println("returndate -" + returndate.length());

			if (returndate.equals("")) {
				RequestDispatcher rd = request.getRequestDispatcher("Unknownuser_returnbook.jsp");
				rd.forward(request, response);
			}

			// taking number of days from Date and converting into Integer
			String newRD = "";
			int rd = -1;
			if (!returndate.equals("")) {

				newRD = returndate.substring(returndate.length() - 2, returndate.length());
				rd = Integer.parseInt(newRD);

			}

			String newTD = todaydate.substring(todaydate.length() - 2, todaydate.length());

			int td = Integer.parseInt(newTD);

			if (returndate.equals(todaydate)) {
				// managing books availability, issue
				Connection con2 = (Connection) DriverManager
						.getConnection("jdbc:mysql://localhost:3306/LibraryManagementSystem", "root", "root");
				PreparedStatement ps2 = con2.prepareStatement(
						"select availability, issued from LibraryManagementSystem.Book where Book_Id=?;");

				ps2.setInt(1, bookid);
				ResultSet rs2 = ps2.executeQuery();
				int availability = -1, issued = -1;
				while (rs2.next()) {
					availability = rs2.getInt("availability");
					issued = rs2.getInt("issued");
				}

				
//				/int numofbooks=(Integer)session.getAttribute("numofbooks");
//				/System.out.println("no of books in returnbook: "+numofbooks);	
//				while(1<=numofbooks) {
				availability++;
				issued--;
//				numofbooks--;}
				if (availability == 11 && issued == -1) {
					// availability=
				}
				PreparedStatement ps3 = con2.prepareStatement(
						"update LibraryManagementSystem.Book set availability=?, issued=? where Book_Id=?;");

				ps3.setInt(1, availability);
				ps3.setInt(2, issued);
				ps3.setInt(3, bookid);
				ps3.executeUpdate();

				// removing issued book from user book
				PreparedStatement ps4 = con2.prepareStatement(
						"delete from UserBookIssueTable." + username + "bookissuetable where return_date=?;");

				ps4.setString(1, returndate);
				ps4.executeUpdate();

				// removing issued book from alluser book
				PreparedStatement ps5 = con2
						.prepareStatement("delete from LibraryManagementSystem.AllBookIssueTable where return_date=?;");

				ps5.setString(1, returndate);
				ps5.executeUpdate();

				response.sendRedirect("Returnbooksuccess.jsp");
				// out.println("<html>");
				// out.println("<head><link\n"
				// + "
				// href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css\"\n"
				// + " rel=\"stylesheet\"\n"
				// + "
				// integrity=\"sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN\"\n"
				// + " crossorigin=\"anonymous\"></head>");
				// out.println("<body>");
				// out.println("<script\n"
				// + "
				// src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js\"\n"
				// + "
				// integrity=\"sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL\"\n"
				// + " crossorigin=\"anonymous\"></script>");
				// out.println("<h2>Book Returned</h2>");
				// out.println("<button><a href='BookIssueTable.jsp'>My book</a></button>");
				// out.println("</body>");
				// out.println("</html>");
			} else if (rd < td) {
				
				int dateDifference = td - rd;
				int price = dateDifference * 50;
				
				HttpSession session1 = request.getSession();
				session1.setAttribute("dateDifference", dateDifference);
				session1.setAttribute("price", price);
				response.sendRedirect("Returnbookmorerd.jsp");

				// out.println("<html>");
				// out.println("<head><link\n"
				// + "
				// href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css\"\n"
				// + " rel=\"stylesheet\"\n"
				// + "
				// integrity=\"sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN\"\n"
				// + " crossorigin=\"anonymous\"></head>");
				// out.println("<body>");
				// out.println("<script\n"
				// + "
				// src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js\"\n"
				// + "
				// integrity=\"sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL\"\n"
				// + " crossorigin=\"anonymous\"></script>");
				// out.println("<h2>Time excceded by "+price+" days..You have pay "+pay +" rs
				// amount!</h2>");
				// out.println("</body>");
				// out.println("</html>");
			} else if (rd > td) {

				Connection con2 = (Connection) DriverManager
						.getConnection("jdbc:mysql://localhost:3306/LibraryManagementSystem", "root", "root");
				PreparedStatement ps2 = con2.prepareStatement(
						"select availability, issued from LibraryManagementSystem.Book where Book_Id=?;");

				ps2.setInt(1, bookid);
				ResultSet rs2 = ps2.executeQuery();
				int availability = -1, issued = -1;
				while (rs2.next()) {
					availability = rs2.getInt("availability");
					issued = rs2.getInt("issued");
				}

				availability++;
				issued--;
				PreparedStatement ps3 = con2.prepareStatement(
						"update LibraryManagementSystem.Book set availability=?, issued=? where Book_Id=?;");

				ps3.setInt(1, availability);
				ps3.setInt(2, issued);
				ps3.setInt(3, bookid);
				ps3.executeUpdate();

				// removing issued book
				PreparedStatement ps4 = con2.prepareStatement(
						"delete from UserBookIssueTable." + username + "bookissuetable where return_date=?;");

				ps4.setString(1, returndate);
				ps4.executeUpdate();

				PreparedStatement ps5 = con2
						.prepareStatement("delete from LibraryManagementSystem.AllBookIssueTable where return_date=?;");

				ps5.setString(1, returndate);
				ps5.executeUpdate();
				response.sendRedirect("Returnbooksuccess.jsp");
				// out.println("<html>");
				// out.println("<head><link\n"
				// + "
				// href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css\"\n"
				// + " rel=\"stylesheet\"\n"
				// + "
				// integrity=\"sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN\"\n"
				// + " crossorigin=\"anonymous\"></head>");
				// out.println("<body>");
				// out.println("<script\n"
				// + "
				// src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js\"\n"
				// + "
				// integrity=\"sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL\"\n"
				// + " crossorigin=\"anonymous\"></script>");
				// out.println("<h2>Book Returned</h2>");
				// out.println("<button><a href='BookIssueTable.jsp'>My book</a></button>");
				// out.println("</body>");
				// out.println("</html>");
			}

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void sendRedirect(String string) {
		// TODO Auto-generated method stub

	}

}
