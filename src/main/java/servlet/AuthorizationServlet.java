package servlet;

import dao.UserDao;
import dto.User;
import useful.CheckSession;
import useful.LogIn;
import useful.PasswordAuthentication;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class AuthorizationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final HttpSession session = request.getSession();
        if (CheckSession.check(session, request)) {
            //response.sendRedirect(request.getContextPath());
            response.sendRedirect("/ks/");
        } else {
            final String username = request.getParameter("username");
            final char[] password = request.getParameter("password").toCharArray();

            final UserDao userDao = (UserDao) request.getServletContext().getAttribute("userDao");
            final int cost = (int) request.getServletContext().getAttribute("cost");

            User user = userDao.getUserByUsername(username);
            PasswordAuthentication passwordAuthentication = new PasswordAuthentication(cost);

            if (user != null && passwordAuthentication.authenticate(password, user.getPassword())) {
                LogIn.logIn(username, user.getPassword(), request, response);
            } else {
                request.getSession().setAttribute("check_password", false);
                response.sendRedirect("authorize");
                //req.getRequestDispatcher("/authorize").forward(req, resp);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
