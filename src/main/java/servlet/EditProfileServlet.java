package servlet;

import service.UserService;
import useful.CheckSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;

@WebServlet("/edit-profile")
public class EditProfileServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (CheckSession.checkCookie(request)) {
            request.setCharacterEncoding("UTF-8");
            HttpSession httpSession = request.getSession();
            int userId = (int) httpSession.getAttribute("user_id");
            final String fullname = request.getParameter("fullname");
            final String username = request.getParameter("username");
            final String email = request.getParameter("email");
            final Date birthdate = Date.valueOf(request.getParameter("birthdate"));
            final char[] password = request.getParameter("password").toCharArray();

            UserService userService = new UserService();

            userService.editUserById(fullname, username, email, birthdate, password, userId);
            response.sendRedirect("profile");
        } else {
            response.sendRedirect("/ks/authorize");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
