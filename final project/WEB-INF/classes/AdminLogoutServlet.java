import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@WebServlet("/adminlogoutservlet")
public class AdminLogoutServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException,ServletException{
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		req.getRequestDispatcher("index.html").include(req,res);
		HttpSession ses=req.getSession(false);
		ses.invalidate();
		res.sendRedirect("index.html");
	}
}