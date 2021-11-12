import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.annotation.*;

@WebServlet("/HomedecCartServlet")

public class HomedecCartServlet extends HttpServlet
{
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
	{
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		CartItems c=null;
		try
		{
			pw.println("<html><body>");
			int q1=Integer.parseInt(req.getParameter("curtains"));
			int q2=Integer.parseInt(req.getParameter("paintings"));
			int q3=Integer.parseInt(req.getParameter("flowerwas"));
			int q4=Integer.parseInt(req.getParameter("chandliers"));
			int q5=Integer.parseInt(req.getParameter("wallhangings"));
			if(q1!=0)
			{
				c=new CartItems();
				c.setId(13);
				c.setName("curtains");
				c.setQuantity(q1);
				int cost=ItemsDatabase.getItemPrice(c.getName());
				c.setPrice(cost);
				c.setTotalPrice(cost*q1);
				CartDatabase.status(c);
			}
			if(q2!=0)
			{
				c=new CartItems();
				c.setId(14);
				c.setName("paintings");
				c.setQuantity(q2);
				int cost=ItemsDatabase.getItemPrice(c.getName());
				c.setPrice(cost);
				c.setTotalPrice(cost*q2);
				CartDatabase.status(c);
			}
			if(q3!=0)
			{
				c=new CartItems();
				c.setId(15);
				c.setName("flowerwas");
				c.setQuantity(q3);
				int cost=ItemsDatabase.getItemPrice(c.getName());
				c.setPrice(cost);
				c.setTotalPrice(cost*q3);
				CartDatabase.status(c);
			}
			if(q4!=0)
			{
				c=new CartItems();
				c.setId(16);
				c.setName("chandliers");
				c.setQuantity(q4);
				int cost=ItemsDatabase.getItemPrice(c.getName());
				c.setPrice(cost);
				c.setTotalPrice(cost*q4);
				CartDatabase.status(c);
			}
			if(q5!=0)
			{
				c=new CartItems();
				c.setId(17);
				c.setName("wallhangings");
				c.setQuantity(q5);
				int cost=ItemsDatabase.getItemPrice(c.getName());
				c.setPrice(cost);
				c.setTotalPrice(cost*q5);
				CartDatabase.status(c);
			}
			pw.println("Items added successfully");
			req.getRequestDispatcher("homedec.html").include(req,res);
		}
		catch(Exception e)
		{
			pw.println(e);
		}
		pw.println("</body></html>");
		pw.close();
	}
}