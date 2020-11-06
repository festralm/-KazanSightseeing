package servlet;

import service.UserService;
import service.UserSightVisitedService;
import service.UserSightWantedService;
import useful.CheckSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/save-as-visited")
public class SaveAsVisitedServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (CheckSession.checkCookie(request)) {
            HttpSession session = request.getSession();

            int sightId = Integer.parseInt(request.getParameter("id"));
            int userId = (int) session.getAttribute("user_id");


            UserService userService = new UserService();

            userService.addVisitedSight(userId, sightId);


            response.sendRedirect("/ks/visited");
        } else {
            response.sendRedirect("/ks/authorize");
        }
    }
}
