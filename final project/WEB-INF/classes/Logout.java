import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
@WebServlet("/logoutservlet")
public class Logout extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		req.getRequestDispatcher("index.html").include(req,res);
		HttpSession ses=req.getSession(false);
		ses.invalidate();
		pw.print("Logged Out");
	}
}