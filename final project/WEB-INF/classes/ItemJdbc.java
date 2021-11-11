import java.sql.*;
public class ItemJdbc{
	public static Connection getConnection()throws Exception{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xepdb1","hr","hr");
		con.setAutoCommit(true);
		return con;
	}
	public static boolean addItem(ItemBean i)throws Exception{
		try{
		Connection con=ItemJdbc.getConnection();
		PreparedStatement ps=con.prepareStatement("insert into item values(s2.nextVal,?,?)");
		String name=i.getName();
		int price=i.getPrice();
		ps.setString(1,name);
		ps.setInt(2,price);
		ps.executeUpdate();
		return true;
		}
		catch(Exception e){
			return false;
		}
	}
	public static boolean removeItem(String id)throws Exception{
		try{
			Connection con=ItemJdbc.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from item where id=?");
			ps.setString(1,id);
			ps.executeUpdate();
			return true;
		}
		catch(Exception e){
			return false;
		}
	}
	
}
		
		
		
		
		
	