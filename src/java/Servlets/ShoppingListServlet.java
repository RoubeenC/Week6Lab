
package Servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Roubeen Chaudhry
 */
public class ShoppingListServlet extends HttpServlet {
    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        String action = request.getParameter("action");
        
         if (action != null && action.equals("logout")){
            session.invalidate();
            
         } else {
                request.setAttribute("username", username);
                getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp" )
                    .forward(request, response); 
                return;
            }
         
         getServletContext().getRequestDispatcher("/WEB-INF/register.jsp" )
            .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        
        if(action != null && action.equals("login")) {
            session.setAttribute("username", request.getParameter("username"));
            System.out.println(request.getParameter("username"));
            response.sendRedirect("");
            
           getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp")
                   .forward(request, response);
            return;
        } else if (action != null && action.equals("add")){
            ArrayList<String> items = (ArrayList<String>) session.getAttribute("items");
            items.add(request.getParameter("item"));
            session.setAttribute("items", items);
            request.setAttribute("list", items);
            
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp")
                    .forward(request, response);
            return;
            
        } else if (action != null && action.equals("delete")){
            ArrayList<String> items = (ArrayList<String>) session.getAttribute("items");
            items.remove(Integer.parseInt(request.getParameter("item")));
            session.setAttribute("item", items);
            request.setAttribute("list", items);
            System.out.println(request.getParameter("item"));
            
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp")
                    .forward(request, response);
            return;
            
        }

    }

}
