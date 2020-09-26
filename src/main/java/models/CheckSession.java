package models;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static java.util.Objects.nonNull;

public class CheckSession {
    public static boolean check(HttpSession session, HttpServletRequest request) {
        if (nonNull(session)) {
            Object login = session.getAttribute("login");
            Object password = session.getAttribute("password");

            if (nonNull(login) && nonNull(password)) {
                return checkCookie(request, (String) login, (String) password);
            }
            else {
                return false;
            }
        }
        return false;
    }

    private static boolean checkCookie(HttpServletRequest request, String login, String password) {
        Cookie[] cookies = request.getCookies();

        for (Cookie cookie : cookies) {
            String cookieName = cookie.getName();

            if (cookieName.equals("user") && cookie.getValue().equals(login + password)){
                return true;
            };
        }
        return false;
    }
}
