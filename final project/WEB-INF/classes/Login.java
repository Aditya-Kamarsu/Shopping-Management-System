import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@WebServlet("/LoginSer")
public class Login extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		try{
		
		String name=req.getParameter("name");
		String pass=req.getParameter("pass");
			if(CustomerDao.login(name,pass)){
				HttpSession ses=req.getSession(true);
			   ses.setAttribute("name",name);
			   ses.setAttribute("pass",pass);
				pw.println("<script>alert('Login Successful');parent.window.location.href='UserDashBoard.html'</script>"); 
				pw.println("<h3>Hello "+name+"</h3>");
			RequestDispatcher rd=req.getRequestDispatcher("/UserDashBoard.html");
			rd.include(req,res);
			}
		else{
			pw.println("<h1 style='text-align:center; color:#000080;'>Invalid contact or name</h1>");
			RequestDispatcher rd=req.getRequestDispatcher("/main.html");
			rd.include(req,res);
		}
		
		}
		catch(Exception e){pw.println(e);}
		pw.close();
	}
}
			
		
