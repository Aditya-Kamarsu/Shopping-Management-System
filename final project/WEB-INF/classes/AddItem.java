import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.*;
@WebServlet("/AddItem")
public class AddItem extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		try{
			ItemBean i=new ItemBean();
			res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		i.setName(req.getParameter("itname"));
		i.setPrice(Integer.parseInt(req.getParameter("itprice")));
		if(ItemJdbc.addItem(i)){
			pw.print("<h1 style='text-align:center'>item added successfully</h1>");
			RequestDispatcher rd=req.getRequestDispatcher("/index.html");
			rd.include(req,res);
		}
		else{
			pw.print("<h1 style='text-align:center'>item not added</h1>");
			RequestDispatcher rd=req.getRequestDispatcher("/index.html");
			rd.include(req,res);
			
		}
		}
		catch(Exception e){}
	}
}
			
		
		