package Com.ServletPackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
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


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String useremail=request.getParameter("email");
		String password=request.getParameter("password");
		System.out.println("username "+useremail);
		System.out.println("password "+password);
		
		
		//Making session again for login users                   
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/LibraryManagementSystem", "root",
					"root");
			PreparedStatement ps1 = con1.prepareStatement("select username from LibraryManagementSystem.User where useremail=?; ");
			ps1.setString(1, useremail);
			
			ResultSet rs=ps1.executeQuery();
			
			
			while(rs.next())
			{
				String username=rs.getString(1);
				
				HttpSession session=request.getSession();
				session.setAttribute("username", username);
			}
			
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		//checking useremail ad password in database
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/LibraryManagementSystem", "root",
					"root");
			PreparedStatement ps = con.prepareStatement("select useremail,password from LibraryManagementSystem.User where useremail=? and password=?; ");
			
			ps.setString(1, useremail);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			boolean flag=false;
			if(rs.next())
			{
				if(useremail.equals(rs.getString(1)) && password.equals(rs.getString(2)))
				{
					flag=true;
				}
			}
			
			PrintWriter out=response.getWriter();
			
			if(flag==true)
			{
				
				response.sendRedirect("index.jsp");	
//				out.println("<html>");
//				out.println("<head><link\n" + 
//						"	href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css\"\n" + 
//						"	rel=\"stylesheet\"\n" + 
//						"	integrity=\"sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN\"\n" + 
//						"	crossorigin=\"anonymous\"></head>");
//				out.println("<body>");
//				out.println("<script\n" + 
//						"		src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js\"\n" + 
//						"		integrity=\"sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL\"\n" + 
//						"		crossorigin=\"anonymous\"></script>");
//				out.print("<h2>Logged Successfully..</h2>");
//				out.print("<button><a href='index.jsp'>Home Page</a></button>");
//				out.print("</body>");
//				out.print("</html>");
			}
			else
			{
				response.sendRedirect("Invalide.jsp");
//				out.println("<html>");
//				out.println("<head><link\n" + 
//						"	href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css\"\n" + 
//						"	rel=\"stylesheet\"\n" + 
//						"	integrity=\"sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN\"\n" + 
//						"	crossorigin=\"anonymous\"></head>");
//				out.println("<body>");
//				out.println("<script\n" + 
//						"		src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js\"\n" + 
//						"		integrity=\"sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL\"\n" + 
//						"		crossorigin=\"anonymous\"></script>");
//				out.print("<h3>Invalid user email and password...Try again</h3>");
//				out.print("<button><a href='Login.jsp'>Login Page</a></button>");
//				out.print("</body>");
//				out.print("</html>");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
