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

import Com.BeanPackage.Book;


@WebServlet("/AddBook")
public class AddBook extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String bookname=request.getParameter("name");
		String genre=request.getParameter("genre");
		String author=request.getParameter("author");
		
		
		Book book=new Book();
		
		book.setBookName(bookname);
		book.setGenre(genre);
		book.setAuthor(author);
		
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory factory=cfg.buildSessionFactory();
		
		Session session=factory.openSession();
		
		Transaction ts=session.beginTransaction();
		session.save(book);
		ts.commit();
		
		session.close();
		factory.close();
		
//		BookPage.jsp
		
		PrintWriter out=response.getWriter();
		
		out.print("<html>");
		out.print("<body>");
		out.print("<h3>Book Saved Successfully..</h3>");
		out.print("<button><a href='BookPage.jsp'>View Books</a></button>");
		out.print("</body>");
		out.print("</html>");
		
	}

}
