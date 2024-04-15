package Com.ServletPackage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import Com.BeanPackage.Admin;

/**
 * Servlet implementation class AdminController
 */
@WebServlet("/AdminController")
public class AdminController extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int admin_id = Integer.parseInt(request.getParameter("id"));
		String admin_name = request.getParameter("name");
		String admin_password = request.getParameter("password");

		Configuration cfg = new Configuration();

		cfg.configure("hibernate.cfg.xml");

		SessionFactory factory = cfg.buildSessionFactory();
		Admin a = new Admin();
		a.setAid(admin_id);
		a.setAname(admin_name);
		a.setApassword(admin_password);

		Session session = factory.openSession();

		Transaction ts = session.beginTransaction();

		session.save(a);

		ts.commit();

		session.close();
		factory.close();

		
		PrintWriter out=response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h3>Register successfully.. Click below button see the book page </h3>");
		out.println("<button> <a href='BookPage.jsp'>Click me</a></button>");
		out.println("</body>");
		out.println("</html>");
		
		
	}

}
