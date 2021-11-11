import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
@WebServlet("/saveservlet")
public class SaveServlet extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		Customer c=new Customer();
		c.setName(req.getParameter("name"));
		c.setEmail(req.getParameter("mail"));
		c.setPass(req.getParameter("pass"));
		c.setContact(req.getParameter("contact"));
		c.setAddress(req.getParameter("address"));
		try{
		if(CustomerDao.save(c)){
			pw.println("<p style='color:azure; font-size:30px;>Please login again!!</h1>");
			RequestDispatcher rd=req.getRequestDispatcher("/usersign.html");
			rd.include(req,res);
		}else{
			pw.println("Sorry!Unable to save record :(");
			RequestDispatcher rd=req.getRequestDispatcher("/usersignup.html");
			rd.include(req,res);
		}
		}catch(Exception e){
		}finally{
		pw.close();
		}
	}
}
		