
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
        String input = request.getParameter("action");
        if (input != null && input.equals("logout")) {
            session.invalidate();
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            request.setAttribute("request", null);
        }
        if (session.getAttribute("username") != null) {
            getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
        } else {
            request.setAttribute("request", "");
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
         ArrayList<String> items = new ArrayList<String>();
        String name = request.getParameter("UserName");
        if (request.getParameter("action").equals("register")) {
            if (name != null && !name.equals("")) {
                session.setAttribute("items", items);
                session.setAttribute("username", name);
            } else {
                request.setAttribute("message", "Enter a name");
                getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            }
        } else if (request.getParameter("action").equals("add")) {
            ArrayList<String> sessionItems = (ArrayList<String>) session.getAttribute("items");
            String item = request.getParameter("item");
            sessionItems.add(item);
            session.setAttribute("items", sessionItems);
        } else if (request.getParameter("action").equals("delete")) {
            ArrayList<String> sessionItems = (ArrayList<String>) session.getAttribute("items");
             String item = request.getParameter("foodName");
            sessionItems.remove(item);
             session.setAttribute("items", sessionItems);
        }
        request.getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);

    }

}
