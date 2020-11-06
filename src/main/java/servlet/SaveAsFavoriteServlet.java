package servlet;

import service.UserSightFavoriteService;
import service.UserSightWantedService;
import useful.CheckSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/save-as-favorite")
public class SaveAsFavoriteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (CheckSession.checkCookie(request)) {
            HttpSession session = request.getSession();

            int sightId = Integer.parseInt(request.getParameter("id"));
            int userId = (int) session.getAttribute("user_id");

            UserSightFavoriteService userSightFavoriteService = new UserSightFavoriteService();
            userSightFavoriteService.addColumn(userId, sightId);

            response.sendRedirect("/ks/favorite");
        } else {
            response.sendRedirect("/ks/authorize");
        }
    }
}
