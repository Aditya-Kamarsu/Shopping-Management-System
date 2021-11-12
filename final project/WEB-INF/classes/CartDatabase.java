import java.sql.*;
import java.util.*;

public class CartDatabase
{
	public static Connection connect()
	{
		Connection c=null;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		    c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xepdb1","hr","hr");
			c.setAutoCommit(true);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return c;
	}
	public static void store(CartItems c)
	{
		try
		{
			Connection con=CartDatabase.connect();
			PreparedStatement ps=con.prepareStatement("insert into cart values(?,?,?,?,?)");
			
			ps.setInt(1,c.getId());
			ps.setString(2,c.getName());
			ps.setInt(3,c.getQuantity());
			ps.setInt(4,c.getPrice());
			ps.setInt(5,c.getTotalPrice());
			ps.executeUpdate();
			ps.close();
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public static void update(CartItems c)
	{
		try
		{
			Connection con=CartDatabase.connect();
			PreparedStatement ps=con.prepareStatement("update cart set quantity=?,totalprice=? where id=?");
			
			ps.setInt(1,c.getQuantity());
			int cost=ItemsDatabase.getItemPrice(c.getName())*c.getQuantity();
			ps.setInt(2,cost);
			ps.setInt(3,c.getId());
			ps.executeUpdate();
			ps.close();
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public static void status(CartItems c)
	{
		try
		{
			Connection con=CartDatabase.connect();
			PreparedStatement ps=con.prepareStatement("select count(*) from cart where id=?");
			
			ps.setInt(1,c.getId());
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				if(rs.getInt(1)==1)
					CartDatabase.update(c);
				else
					CartDatabase.store(c);
			}
			else
			{
				CartDatabase.store(c);
			}
			ps.close();
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public static List<CartItems> getCartDetails()
	{
		List<CartItems> l=new ArrayList<CartItems>();
		try
		{
			Connection con=CartDatabase.connect();
			PreparedStatement ps=con.prepareStatement("select * from cart");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				CartItems c=new CartItems();
				c.setId(rs.getInt(1));
				c.setName(rs.getString(2));
				c.setQuantity(rs.getInt(3));
				c.setPrice(rs.getInt(4));
				c.setTotalPrice(rs.getInt(5));
				l.add(c);
			}
			ps.close();
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return l;
	}
	
}