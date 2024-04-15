package Com.ServletPackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Connection;


@WebServlet("/BookIssueServlet2")
public class BookIssueServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("html/text");
		
		int bookid = Integer.parseInt(request.getParameter("id"));
		String bookname = request.getParameter("name");
		int numofbooks=Integer.parseInt(request.getParameter("nums"));
		String useremail = request.getParameter("useremail");
		String issuedate = request.getParameter("issuedate");
		String returndate = request.getParameter("returndate");

		HttpSession session1 = request.getSession();
		String username = (String) session1.getAttribute("username");

		// username=username.replace(' ', '_');
		PrintWriter out = response.getWriter();

		try {

			// first checking book present or not!

			Class.forName("com.mysql.jdbc.Driver");
			Connection con = (Connection) DriverManager
					.getConnection("jdbc:mysql://localhost:3306/LibraryManagementSystem", "root", "root");
			PreparedStatement ps = con.prepareStatement(
					"select Book_Id,bookName,genre from LibraryManagementSystem.Book where Book_Id=? and bookName=?");
			ps.setInt(1, bookid);
			ps.setString(2, bookname);
			ResultSet rs = ps.executeQuery();
			boolean flag = false;
			String genre = "";
			if (rs.next()) {

				if (bookid == rs.getInt(1) && bookname.equalsIgnoreCase(rs.getString(2))) {
					flag = true;
					bookname = rs.getString(2);
					genre = rs.getString("genre");
				}
			}

			if (flag == true) {
				// PreparedStatement ps1 = con.prepareStatement("create table"+ username+"table
				// (bookid int(50) primary key, bookname varchar(50) not null, issuedate date
				// not null, return date not null ); ");
				//
				// ps1.execute();

				// BookIssue bi=new BookIssue();
				// bi.setBookId(bookid);
				// bi.setUsername(username);
				// bi.setBookName(bookname);
				// bi.setIssueDate(issuedate);
				// bi.setReturnDate(returndate);
				//
				// Configuration cfg=new Configuration();
				// cfg.configure("Book.cfg.xml");
				// SessionFactory factory=cfg.buildSessionFactory();
				// Session session1=factory.openSession();
				//
				// Transaction ts=session1.beginTransaction();

				// session1.save(bi);
				// ts.commit();
				//
				// session1.close();
				// factory.close();

				// Adding books to inside user book table
				Connection con1 = (Connection) DriverManager
						.getConnection("jdbc:mysql://localhost:3306/UserBookIssueTable", "root", "root");
				PreparedStatement ps1 = con1.prepareStatement("insert into UserBookIssueTable." + username
						+ "bookissuetable (bookid,bookname,useremail,genre,issue_date,return_date) values (?,?,?,?,?,?);");

				ps1.setInt(1, bookid);
				ps1.setString(2, bookname);
				ps1.setString(3, useremail);
				ps1.setString(4, genre);
				ps1.setString(5, issuedate);
				ps1.setString(6, returndate);
				ps1.executeUpdate();

				// adding books in all the user book issue table
				PreparedStatement ps4 = con1.prepareStatement(
						"insert into LibraryManagementSystem.AllBookIssueTable (bookid,bookname,useremail,genre,issue_date,return_date) values (?,?,?,?,?,?);");

				ps4.setInt(1, bookid);
				ps4.setString(2, bookname);
				ps4.setString(3, useremail);
				ps4.setString(4, genre);
				ps4.setString(5, issuedate);
				ps4.setString(6, returndate);
				ps4.executeUpdate();

				// managing availability issue

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
                   int temp=numofbooks;
				while(1<=numofbooks) {
				availability--;
				issued++;
				numofbooks--;
				}
				numofbooks=	temp;
				session1.setAttribute("numofbooks", numofbooks);
				
				if (availability == -1 && issued == 11) {
					availability = 10;
					issued = 0;
				}

				PreparedStatement ps3 = con2.prepareStatement(
						"update LibraryManagementSystem.Book set availability=?, issued=? where Book_Id=?;");

				ps3.setInt(1, availability);
				ps3.setInt(2, issued);
				ps3.setInt(3, bookid);
				ps3.executeUpdate();

				// =======================================================
				response.sendRedirect("Bookissuesuccess.jsp");
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
				// out.println("<h2>Book Issued</h2>");
				// out.println("<button><a href='BookIssueTable.jsp'>My book</a></button>");
				// out.println("</body>");
				// out.println("</html>");

			} else {
				response.sendRedirect("Bookissueunsuccess.jsp");
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
				// out.println("<h2>Issued book is not exist...</h2>");
				// out.println("<button><a href='BookPage.jsp'>View books</a></button>");
				// out.println("</body>");
				// out.println("</html>");
			}

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
