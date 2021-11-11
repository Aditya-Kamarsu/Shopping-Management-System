import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.util.*;
@WebServlet("/viewservlet")
public class ViewServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		List<Customer> l=CustomerDao.getAllCustomers();
		pw.print("<table border='1' width=80% height=80%><tr><th>Id</th><th>Name</th><th>Email</th><th>Password</th><th>Contact</th><th>Address</th></tr>");
		for(Customer c:l){
		pw.print("<tr><td>"+c.getId()+"</td><td>"+c.getName()+"</td><td>"+c.getEmail()+"</td><td>"+c.getPass()+"</td><td>"+c.getContact()+"</td><td>"+c.getAddress()+"</td></tr>");
		}
		pw.close();
	}
}