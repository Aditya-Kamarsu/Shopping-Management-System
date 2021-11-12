import java.sql.*;
import java.util.*;
import javax.servlet.annotation.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

@WebServlet("/CartServlet")

public class CartServlet extends HttpServlet
{
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
	{
		PrintWriter pw=res.getWriter();
		List<CartItems> l=new ArrayList<CartItems>();
		try
		{
			res.setContentType("text/html");
			l=CartDatabase.getCartDetails();
			pw.println("<html>");
			pw.println("<head>    <meta charset='UTF-8'>"
    
			+"<meta name='viewport' content='width=device-width, initial-scale=1.0'>"
			+"<title>Cart</title>"
			+"<script src='https://cdn.jsdelivr.net/npm/sweetalert2@11'></script>"
			+"<style type='text/css'>"
			+"body{overflow:auto;font-family: 'Merriweather', sans-serif;background-color: #ebf2ff;}"
			+"div.header{width:100%;overflow:hidden;height:60px;border:1px solid black;margin-right: 0px;background-image: linear-gradient(#ff512f 0%,#dd2476 51%,#ff512f 100%);}"
			+"a,h3{float:left;}"
			+"a{text-decoration: none;color:black;}"
			+"div.content{background-color: #ebf2ff;width:100%;height:auto;overflow:auto;}"
			+"th{color:50px solid grey;text-align: center;}"
			+"#footer{border:1px solid black;width:100%;height:auto;overflow:auto;position:absolute;bottom:0px;background-image: linear-gradient(#ff512f 0%,#dd2476 51%,#ff512f 100%);}"
			+"@media  screen and (max-width:1025px){"
			+"    table{width:100%;}"
			+"    td,th{padding:5px;}}"
			+"@media only screen and (min-width:1025px){"
			+"    table{width:100%;}"
			+"    td,th{padding:20px;text-align:center;}}"
			+"#proceed{position:absolute;bottom:5px;overflow:hidden;right:0px;width:auto;height:auto;border:0px;font-weight:bold;background-color: #ebf2ff;}"
			+"#proceed:hover{background-color:white;}"
			+"h2{text-align:center;}"
			+"#valid{color:blue;}"
			+"table{overflow:auto;margin-left:auto;margin-right:auto;}"
			+"</style></head>"
			+"<body>"
			+"<div class='header'>"
            +"<a href='UserDashBoard.html'><h3>Back</h3> &nbsp; </a><h2 id='align'><img src='cart.jpg' width=30px height=30px/> User Cart</h2></div>"
			+"<div class='content'>");
			
			pw.println("<table border=1px cellspacing=0px solid grey><tr><th>Id</th><th>Name</th><th>Quantity</th><th>Price</th><th>TotalPrice</th></tr>");
			int sum=0;
			for(CartItems c:l)
			{
				pw.print("<tr><td>"+c.getId()+"</td><td>"+c.getName()+"</td><td>"+c.getQuantity()+"</td><td>"+c.getPrice()+"</td><td>"+c.getTotalPrice()+"</td></tr>");
				sum+=c.getTotalPrice();
			}
			
			pw.println("</table><br/><br/>"
			//+"<h2>Have Coupon?&nbsp;<input type='text' id='coupon'/><input type='button' value='Apply' id='Apply'/><span id='valid'></span></h2></div>"
			+"<div id='footer'>"
			+"<h2>"
			+"<span id='payable'></span><br/>"
			//+"<span id='savings'></span><br/>"
			+"</h2>"
			+"<form action='billing.html'><button type='button' onclick='swealert()' id='proceed'>proceed to payment</button></form> </div>");
			pw.println("<script type='text/javascript'>document.getElementById('payable').innerHTML='Total Payable='+"+sum);
			
			
			pw.println("function swealert(){Swal.fire({title: 'Do you want to move to Payment Page ?',showDenyButton: true,showCancelButton: true,confirmButtonText: 'Yes',denyButtonText: 'No',}).then((result) => {"
			+"if (result.isConfirmed) {addEventListener('click',navigate());} else if (result.isDenied) {Swal.fire('&#128532;', '', '')}});}"
			+"function navigate(){window.location.href='billing.html';}</script>");
			
			
			
			//pw.println(sum);
			/*+"<script type='text/javascript'>");
	pw.println("document.getElementById('payable').innerHTML='Total Payable: '"+sum+";document.getElementById('savings').innerHTML='Total Savings: 0';document.getElementById('Apply').addEventListener('click',discount);"
	+"function discount(){var coupon=document.getElementById('coupon').value;if(coupon=='revanth'){"
	+"document.getElementById('valid').innerHTML='<br/><br/>Hurray! Coupon Applied successfully(20%)';"
	+"document.getElementById('payable'.innerHTML='Total Payable: '+"+(0.8*sum)+";");
	pw.println("document.getElementById('savings'.innerHTML='Total Savings: '+"+(0.2*sum)+";}"
	+"else{"
	+"document.getElementById('payable').innerHTML='Total Payable: '+"+sum+";"
	+"document.getElementById('savings').innerHTML='Total Savings: 0';"
	+"document.getElementById('valid').innerHTML='<br/><br/>Invalid Coupon or Expired';}}"
    +"function swealert(){Swal.fire({title: 'Do you want to move to Payment Page ?',showDenyButton: true,showCancelButton: true,confirmButtonText: 'Yes',denyButtonText: 'No',}).then((result) => {"
    +"if (result.isConfirmed) {addEventListener('click',navigate());} else if (result.isDenied) {Swal.fire('&#128532;', '', '')}});}"
	+"function navigate(){window.location.href='billing.html';}</script>");*/
			pw.println("</body></html>");
		}
		catch(Exception e)
		{
			pw.println(e);
		}
		
		pw.close();
	}
}