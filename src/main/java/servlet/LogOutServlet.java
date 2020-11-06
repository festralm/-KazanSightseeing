package servlet;

import useful.CheckSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/logout")
public class LogOutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (CheckSession.checkCookie(request)) {
            Cookie cookie = new Cookie("user_id", "");
            cookie.setMaxAge(0);
            response.addCookie(cookie);
            request.getSession().setAttribute("user_id", null);
        }
        response.sendRedirect("/ks/");
    }
}