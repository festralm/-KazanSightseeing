package servlet;

import dto.Sight;
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

@WebServlet("/favorite")
public class FavoriteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        final HttpSession session = request.getSession();
        if (CheckSession.checkCookie(request)) {
            int userId = (int) session.getAttribute("user_id");

            UserSightFavoriteService userSightFavoriteService = new UserSightFavoriteService();
            Sight[] sights = userSightFavoriteService.getFavoriteSightsByUserId(userId);

            request.setAttribute("sights", sights);

            request.getRequestDispatcher("/favorites_page.jsp").forward(request, response);

        } else {
            response.sendRedirect("/ks/authorize");
        }
    }
}
