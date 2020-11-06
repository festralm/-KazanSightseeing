package servlet;

import service.UserService;
import useful.CheckSession;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("")
public class MainServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServletContext servletContext = getServletContext();
        if (CheckSession.checkCookie(request)) {
            UserService userService = new UserService();
            final HttpSession session = request.getSession();
            int userId = (int) session.getAttribute("user_id");
            request.setAttribute("rating", userService.getRatingByUserId(userId));
            servletContext.getRequestDispatcher("/home_page.jsp")
                    .forward(request, response);
        } else {
            servletContext.getRequestDispatcher("/welcome_page.jsp")
                    .forward(request, response);
        }
    }
}
