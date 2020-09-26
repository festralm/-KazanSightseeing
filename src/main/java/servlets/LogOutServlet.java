package servlets;

import models.CheckSession;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/logout")
public class LogOutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (CheckSession.check(req.getSession(), req)) {
            Cookie cookie = new Cookie("user", "");
            cookie.setMaxAge(0);
//          cookie.setMaxAge(-1); // данные удалятся после закрытия браузера
            resp.addCookie(cookie);
        }

        resp.sendRedirect("/kazanSightseeing/");
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
