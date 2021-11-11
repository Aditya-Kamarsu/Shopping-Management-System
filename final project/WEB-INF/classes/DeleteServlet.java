import java.io.*;  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.*;
@WebServlet("/deleteservlet")  
public class DeleteServlet extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
             throws ServletException, IOException {  
			 response.setContentType("text/html");
			 PrintWriter pw=response.getWriter();
        String sid=request.getParameter("cid");  
        int id=Integer.parseInt(sid);  
        CustomerDao.delete(id);  
       response.sendRedirect("defaultadmindb.html");
    }  
}  
