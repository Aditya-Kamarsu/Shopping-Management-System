import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@WebServlet("/adminloginservlet")
public class AdminLoginServlet extends HttpServlet{
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		String name=req.getParameter("name");
		String pass=req.getParameter("pass");
		if(name.equals("CMI-ADMIN") && pass.equals("CMI-1000@1234a")){
			HttpSession ses=req.getSession(true);
			ses.setAttribute("name",name);
			ses.setAttribute("pass",pass);
			pw.println("<script>alert('Login Successful');parent.window.location.href='AdminDashBoard.html'</script>"); 
			
			
		}else{
			pw.println("<script>alert('Invalid Credentials');</script>");
			pw.println("<script>parent.window.location.href='main.html'</script>"); 
			//RequestDispatcher rd=req.getRequestDispatcher("/AdminDashBoard.html");
			//rd.include(req,res);
		}
	}
}