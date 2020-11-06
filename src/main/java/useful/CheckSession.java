package useful;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static java.util.Objects.nonNull;

public class CheckSession {
//    public static boolean check(HttpSession httpSession, HttpServletRequest request) {
//        if (nonNull(httpSession)) {
//
//            Object userId = httpSession.getAttribute("user_id");
//            if (nonNull(userId)) {
//                if (checkCookie(request, (int) userId)) {
//                    return true;
//                } else {
//                    return false;
//                }
//            } else {
//                return false;
//            }
//        }
//        return false;
//    }

    public static boolean checkCookie(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session != null) {
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    String cookieName = cookie.getName();
                    if (cookieName.equals("user_id")) {
                        session.setAttribute("user_id", Integer.parseInt(cookie.getValue()));
                        return true;
                    }
                }
            }
        }
        return false;

    }
}