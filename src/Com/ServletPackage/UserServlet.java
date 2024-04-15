package Com.ServletPackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import Com.BeanPackage.BookIssue;
import Com.BeanPackage.User;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("name");
		username = username.replace(' ', '_');
		String useremail = request.getParameter("email");
		String password = request.getParameter("password");
		String cnfpassword = request.getParameter("cnfpassword");

		PrintWriter out = response.getWriter();

		if (password.equals(cnfpassword)) {

			HttpSession session1 = request.getSession();
			session1.setAttribute("username", username);

			User user = new User();

			user.setUsername(username);
			user.setUemail(useremail);
			user.setPassword(password);

			// hibernate
			Configuration cfg = new Configuration();
			cfg.configure("hibernate.cfg.xml");

			SessionFactory factory = cfg.buildSessionFactory();

			Session session = factory.openSession();
			Transaction ts = session.beginTransaction();

			session.save(user);
			ts.commit();

			session.close();
			factory.close();

			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/UserBookIssueTable", "root",
						"root");
				PreparedStatement ps = con.prepareStatement("create table " + username
						+ "bookissuetable (bookid int(25) not null,bookname varchar(50) not null, useremail varchar(50) not null, genre varchar(40) not null, issue_date date not null, return_date date not null );");
				ps.execute();

			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			response.sendRedirect("Login.jsp");
			// out.println("<html>");
			// out.println("<head><link\n" +
			// "
			// href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css\"\n"
			// +
			// " rel=\"stylesheet\"\n" +
			// "
			// integrity=\"sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN\"\n"
			// +
			// " crossorigin=\"anonymous\"></head>");
			// out.println("<body>");
			// out.println("<script\n" +
			// "
			// src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js\"\n"
			// +
			// "
			// integrity=\"sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL\"\n"
			// +
			// " crossorigin=\"anonymous\"></script>");
			// out.println("<h2>User saved successfully..</h2>");
			// out.println("<button><a href='Login.jsp'>Login Page</a></button>");
			// out.println("</body>");
			// out.println("</html>");
		} else {
			response.sendRedirect("InvalidUser.jsp");
			// out.println("<html>");
			// out.println("<head><link\n" +
			// "
			// href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css\"\n"
			// +
			// " rel=\"stylesheet\"\n" +
			// "
			// integrity=\"sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN\"\n"
			// +
			// " crossorigin=\"anonymous\"></head>");
			// out.println("<body>");
			// out.println("<script\n" +
			// "
			// src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js\"\n"
			// +
			// "
			// integrity=\"sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL\"\n"
			// +
			// " crossorigin=\"anonymous\"></script>");
			// out.println("<h2>Password doesn't matched try again</h2>");
			// out.println("<button><a href='user.jsp'>User page</a></button>");
			// out.println("</body>");
			// out.println("</html>");
		}

	}

}
