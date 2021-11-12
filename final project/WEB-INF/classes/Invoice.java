import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    
import java.util.*;
@WebServlet("/inv")
public class Invoice extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        HttpSession session = request.getSession(false);
        String name = (String) session.getAttribute("name");
        String password = (String) session.getAttribute("pass");

        Customer customer = CustomerDao.getCustomerByNamePass(name, password);
        String address = customer.getAddress();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();  
        LocalDateTime nex= now.plusDays(2);
       writer.println("<!DOCTYPE html><html lang='en'><head><meta charset='UTF-8'><meta http-equiv='X-UA-Compatible' content='IE=edge'><meta name='viewport' content='width=device-width, initial-scale=1.0'><title>Invoice</title><link rel='stylesheet' href='invoice.css'></head>");
       writer.println("<body><div class='invhead'>Invoice</div>");
       writer.println("<div class='adr'>"+name+"<br>"+address+"</div><h2>CoMake<span>IT</span> </h2>");
      writer.println("<center>");
       writer.println("<table border='1px solid black' cellspacing='1'>");
       writer.println("<tr><th>Item Id</th>");
       writer.println("<th>Item Name</th>");
       writer.println("<th>Quantity</th>");
       writer.println("<th>Price</th>");
       writer.println("<th>Total Cost</th></tr>");
       int Total = 0;
       List<CartItems> items = CartDatabase.getCartDetails();
       for(CartItems item : items){
       writer.println("<tr><td>");
       writer.println(item.getId()+"</td><td>");
       writer.println(item.getName()+"</td><td>");
       writer.println(item.getQuantity()+"</td><td>");
       writer.println(item.getPrice()+"</td><td>");
       writer.println(item.getTotalPrice()+"</td></tr>");
       Total += item.getPrice() * item.getQuantity();
       }
       writer.println("<tr>  <td colspan='5'>Total Bill Amount is :: "+Total+"</td></tr></table>");
       writer.println("<button onclick='down()' id='btn'><img src='download.gif' alt='Download Button' width='50px'></button>");
       writer.println(" Your Order will be Delivered By "+nex);
       writer.println(" </center> <script>");
       writer.println(" function down(){document.getElementById('btn').style.display = 'none';window.print();document.getElementById('btn').style.display = 'block';}");
    
       writer.println("</script></body></html>");
        writer.close();
    }
}