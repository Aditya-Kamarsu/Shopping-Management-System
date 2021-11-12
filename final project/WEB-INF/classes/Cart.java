import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@WebServlet("/CartServlet")
public class Cart extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        List<CartItem> cartItems = CartDatabase.getCartDetails();
        for(CartItem cartItem : cartItems){
            writer.println()
        }

    }
}