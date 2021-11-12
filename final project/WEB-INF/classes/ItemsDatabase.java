import java.sql.*;
import java.util.*;

public class ItemsDatabase
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
	public static int getItemPrice(String name)
	{
		try
		{
			Connection con=ItemsDatabase.connect();
			PreparedStatement ps=con.prepareStatement("select price from items where name=?");
			ps.setString(1,name);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				return rs.getInt(1);
			}
			ps.close();
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return -1;
	}
}