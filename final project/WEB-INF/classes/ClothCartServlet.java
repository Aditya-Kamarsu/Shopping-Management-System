import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.annotation.*;

@WebServlet("/ClothCartServlet")

public class ClothCartServlet extends HttpServlet
{
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
	{
		res.setContentType("text/html");
		PrintWriter pw=res.getWriter();
		CartItems c=null;
		try
		{
			pw.println("<html><body>");
			int q1=Integer.parseInt(req.getParameter("kidswear-boy"));
			int q2=Integer.parseInt(req.getParameter("kidswear-girl"));
			int q3=Integer.parseInt(req.getParameter("menswear-shirt"));
			int q4=Integer.parseInt(req.getParameter("menswear-pant"));
			int q5=Integer.parseInt(req.getParameter("womenswear-traditional"));
			int q6=Integer.parseInt(req.getParameter("womenswear-western"));
			if(q1!=0)
			{
				c=new CartItems();
				c.setId(7);
				c.setName("kidswear-boy");
				c.setQuantity(q1);
				int cost=ItemsDatabase.getItemPrice(c.getName());
				c.setPrice(cost);
				c.setTotalPrice(cost*q1);
				CartDatabase.status(c);
			}
			if(q2!=0)
			{
				c=new CartItems();
				c.setId(8);
				c.setName("kidswear-girl");
				c.setQuantity(q2);
				int cost=ItemsDatabase.getItemPrice(c.getName());
				c.setPrice(cost);
				c.setTotalPrice(cost*q2);
				CartDatabase.status(c);
			}
			if(q3!=0)
			{
				c=new CartItems();
				c.setId(9);
				c.setName("menswear-shirt");
				c.setQuantity(q3);
				int cost=ItemsDatabase.getItemPrice(c.getName());
				c.setPrice(cost);
				c.setTotalPrice(cost*q3);
				CartDatabase.status(c);
			}
			if(q4!=0)
			{
				c=new CartItems();
				c.setId(10);
				c.setName("menswear-pant");
				c.setQuantity(q4);
				int cost=ItemsDatabase.getItemPrice(c.getName());
				c.setPrice(cost);
				c.setTotalPrice(cost*q4);
				CartDatabase.status(c);
			}
			if(q5!=0)
			{
				c=new CartItems();
				c.setId(11);
				c.setName("womenswear-traditional");
				c.setQuantity(q5);
				int cost=ItemsDatabase.getItemPrice(c.getName());
				c.setPrice(cost);
				c.setTotalPrice(cost*q5);
				CartDatabase.status(c);
			}
			if(q6!=0)
			{
				c=new CartItems();
				c.setId(12);
				c.setName("womenswear-western");
				c.setQuantity(q6);
				int cost=ItemsDatabase.getItemPrice(c.getName());
				c.setPrice(cost);
				c.setTotalPrice(cost*q6);
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