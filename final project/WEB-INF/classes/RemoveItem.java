import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.*;
@WebServlet("/RemoveItem")
public class RemoveItem extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		try{
			res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		if(ItemJdbc.removeItem(req.getParameter("itid"))){
			pw.print("<h1 style='text-align:center'> item removed successfully</h1>");
			RequestDispatcher rd=req.getRequestDispatcher("/removeitem.html");
			rd.include(req,res);
		}
		else{
			pw.print("<h1 style='text-align:center'>item not removed</h1>");
			RequestDispatcher rd=req.getRequestDispatcher("/removeitem.html");
			rd.include(req,res);
		}
		}
		catch(Exception e){}
	}
}