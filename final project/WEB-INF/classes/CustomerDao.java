import java.sql.*;
import java.io.*;
import java.util.*;
public class CustomerDao{
	public static Connection getConnection(){
		Connection con=null;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		    con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xepdb1","hr","hr");
			con.setAutoCommit(true);
		}catch(Exception e){
			System.out.println(e);
		}return con;
	} public static boolean save(Customer c) throws Exception{
		int s=0;
		try{
			Connection con=CustomerDao.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into Customers values(sequence_1.nextval,?,?,?,?,?)");
			//ps.setInt(1,sequence_1.nextval);
			ps.setString(1,c.getName());
			ps.setString(2,c.getEmail());
			ps.setString(3,c.getPass());
			ps.setString(4,c.getContact());
			ps.setString(5,c.getAddress());
			s=ps.executeUpdate();
			con.setAutoCommit(true);
			ps.close();
			con.close();
		}finally{}
		return true;
	}public static int delete(int id){
		int s=0;
		try{
		Connection con=CustomerDao.getConnection();
		PreparedStatement ps=con.prepareStatement("delete from Customers where id=?");
		ps.setInt(1,id);
		s=ps.executeUpdate();
		ps.close();
		con.close();
		}catch(Exception e){
			System.out.println(e);
		}return s;
	} public static int update(Customer c){  
        int status=0;  
        try{  
            Connection con=CustomerDao.getConnection();  
            PreparedStatement ps=con.prepareStatement("update Customers set name=?,email=?,password=?,mobile=?,address=? where id=?");  
            ps.setString(1,c.getName());  
            ps.setString(2,c.getEmail());  
            ps.setString(3,c.getPass());  
            ps.setString(4,c.getContact());  
			ps.setString(5,c.getAddress());
            ps.setInt(6,c.getId());  
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
	public static Customer getCustomerByContact(String contact){
		Customer c=new Customer();
		try{
			Connection con=CustomerDao.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from Customers where mobile=?");
			ps.setString(1,contact);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				c.setId(rs.getInt(1));
				c.setName(rs.getString(2));
				c.setEmail(rs.getString(3));
				c.setPass(rs.getString(4));
				c.setContact(rs.getString(5));
				c.setAddress(rs.getString(6));
			}ps.close();
			con.close();
		}catch(Exception e){
			System.out.println(e);
		}return c;
	}public static List<Customer> getAllCustomers(){
		List<Customer> l=new ArrayList<Customer>();
		try{
			Connection con=CustomerDao.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from Customers");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Customer c=new Customer();
				c.setId(rs.getInt(1));
				c.setName(rs.getString(2));
				c.setEmail(rs.getString(3));
				c.setPass(rs.getString(4));
				c.setContact(rs.getString(5));
				c.setAddress(rs.getString(6));
				l.add(c);
			}ps.close();
			con.close();
		}catch(Exception e){
			System.out.println(e);
		}return l;
	}public static boolean login(String mobile,String password) throws Exception{
		try{
			Connection con=CustomerDao.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from Customers where mobile=? and password=?");
			ps.setString(1,mobile);
			ps.setString(2,password);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				return true;
			}
			return false;
			
		}finally{}
	}
}
		
