import java.io.*;
import java.util.*;
public class Customer{
	private int id;
	private String name,email,pass,mob,address;
	public void setId(int id){
		this.id=id;
	}public int getId(){
		return this.id;
	}public void setName(String name){
		this.name=name;
	}public String getName(){
		return this.name;
	}public void setEmail(String email){
		this.email=email;
	}public String getEmail(){
		return this.email;
	}public void setPass(String pass){
		this.pass=pass;
	}public String getPass(){
		return this.pass;
	}public void setContact(String mob){
		this.mob=mob;
	}public String getContact(){
		return this.mob;
	}public void setAddress(String address){
		this.address=address;
	}public String getAddress(){
		return this.address;
	}
}