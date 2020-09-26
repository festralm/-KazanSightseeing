package models;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LogIn {
    public static void logIn(String login, String password, ServletRequest servletRequest, ServletResponse servletResponse,
                             HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {

        httpServletRequest.getSession().setAttribute("login", login);
        httpServletRequest.getSession().setAttribute("password", password);
        httpServletRequest.getSession().setAttribute("check_password", true);

        Cookie cookie = new Cookie("user", login + password);

        if (servletRequest.getParameter("remember") == null) {
            cookie.setMaxAge(60 * 30);
        } else {
            cookie.setMaxAge(60 * 60 * 2);
        }

        httpServletResponse.addCookie(cookie);

        servletRequest.getRequestDispatcher("html/helloPageAuthorized.html").forward(servletRequest, servletResponse);
    }
}
