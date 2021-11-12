import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.annotation.*;

@WebServlet("/FootwearCartServlet")

public class FootwearCartServlet extends HttpServlet
{
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
	{
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		CartItems c=null;
		try
		{
			pw.println("<html><body>");
			int q1=Integer.parseInt(req.getParameter("sportsshoe"));
			int q2=Integer.parseInt(req.getParameter("formalshoe"));
			int q3=Integer.parseInt(req.getParameter("sandel"));
			int q4=Integer.parseInt(req.getParameter("heels"));
			int q5=Integer.parseInt(req.getParameter("slippers"));
			if(q1!=0)
			{
				c=new CartItems();
				c.setId(18);
				c.setName("sportsshoe");
				c.setQuantity(q1);
				int cost=ItemsDatabase.getItemPrice(c.getName());
				c.setPrice(cost);
				c.setTotalPrice(cost*q1);
				CartDatabase.status(c);
			}
			if(q2!=0)
			{
				c=new CartItems();
				c.setId(19);
				c.setName("formalshoe");
				c.setQuantity(q2);
				int cost=ItemsDatabase.getItemPrice(c.getName());
				c.setPrice(cost);
				c.setTotalPrice(cost*q2);
				CartDatabase.status(c);
			}
			if(q3!=0)
			{
				c=new CartItems();
				c.setId(20);
				c.setName("sandel");
				c.setQuantity(q3);
				int cost=ItemsDatabase.getItemPrice(c.getName());
				c.setPrice(cost);
				c.setTotalPrice(cost*q3);
				CartDatabase.status(c);
			}
			if(q4!=0)
			{
				c=new CartItems();
				c.setId(21);
				c.setName("heels");
				c.setQuantity(q4);
				int cost=ItemsDatabase.getItemPrice(c.getName());
				c.setPrice(cost);
				c.setTotalPrice(cost*q4);
				CartDatabase.status(c);
			}
			if(q5!=0)
			{
				c=new CartItems();
				c.setId(22);
				c.setName("slippers");
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