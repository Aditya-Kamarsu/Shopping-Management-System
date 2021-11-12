import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.annotation.*;

@WebServlet("/ElectronicsCartServlet")

public class ElectronicsCartServlet extends HttpServlet
{
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
	{
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		CartItems c=null;
		try
		{
			pw.println("<html><body>");
			int q1=Integer.parseInt(req.getParameter("smartphone"));
			int q2=Integer.parseInt(req.getParameter("washingmachine"));
			int q3=Integer.parseInt(req.getParameter("TV"));
			int q4=Integer.parseInt(req.getParameter("laptop"));
			int q5=Integer.parseInt(req.getParameter("keypad-mobile"));
			int q6=Integer.parseInt(req.getParameter("iphone"));
			if(q1!=0)
			{
				c=new CartItems();
				c.setId(1);
				c.setName("smartphone");
				c.setQuantity(q1);
				int cost=ItemsDatabase.getItemPrice(c.getName());
				c.setPrice(cost);
				c.setTotalPrice(cost*q1);
				CartDatabase.status(c);
			}
			if(q2!=0)
			{
				c=new CartItems();
				c.setId(2);
				c.setName("washingmachine");
				c.setQuantity(q2);
				int cost=ItemsDatabase.getItemPrice(c.getName());
				c.setPrice(cost);
				c.setTotalPrice(cost*q2);
				CartDatabase.status(c);
			}
			if(q3!=0)
			{
				c=new CartItems();
				c.setId(3);
				c.setName("TV");
				c.setQuantity(q3);
				int cost=ItemsDatabase.getItemPrice(c.getName());
				c.setPrice(cost);
				c.setTotalPrice(cost*q3);
				CartDatabase.status(c);
			}
			if(q4!=0)
			{
				c=new CartItems();
				c.setId(4);
				c.setName("laptop");
				c.setQuantity(q4);
				int cost=ItemsDatabase.getItemPrice(c.getName());
				c.setPrice(cost);
				c.setTotalPrice(cost*q4);
				CartDatabase.status(c);
			}
			if(q5!=0)
			{
				c=new CartItems();
				c.setId(5);
				c.setName("keypad-mobile");
				c.setQuantity(q5);
				int cost=ItemsDatabase.getItemPrice(c.getName());
				c.setPrice(cost);
				c.setTotalPrice(cost*q5);
				CartDatabase.status(c);
			}
			if(q6!=0)
			{
				c=new CartItems();
				c.setId(6);
				c.setName("iphone");
				c.setQuantity(q6);
				int cost=ItemsDatabase.getItemPrice(c.getName());
				c.setPrice(cost);
				c.setTotalPrice(cost*q6);
				CartDatabase.status(c);
			}
			pw.println("Items added successfully");
			req.getRequestDispatcher("electronics.html").include(req,res);
		}
		catch(Exception e)
		{
			pw.println(e);
		}
		pw.println("</body></html>");
		pw.close();
	}
}