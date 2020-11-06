package servlet;

import dao.interfaces.UserDao;
import dto.User;
import service.UserService;
import useful.CheckSession;
import useful.LogIn;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;

@WebServlet("/register-in")
public class RegistrationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        final String username = request.getParameter("username");
        final char[] password = request.getParameter("password").toCharArray();
        final String email = request.getParameter("email");

        HttpSession session = request.getSession();

        if (CheckSession.checkCookie(request)) {
            response.sendRedirect(request.getContextPath());
        } else {
            UserService userService = new UserService();

            userService.addNewUser(username, password, email);

            int id = userService.getUserIdByUsername(username);
            LogIn.logIn(id, request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
