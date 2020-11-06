package servlet;

import dto.Achievement;
import dto.Sight;
import service.AchievementService;
import service.UserSightVisitedService;
import useful.CheckSession;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/visited")
public class VisitedServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        final HttpSession session = request.getSession();
        if (CheckSession.checkCookie(request)) {
            int userId = (int) session.getAttribute("user_id");

            UserSightVisitedService userSightVisitedService = new UserSightVisitedService();
            Sight[] sights = userSightVisitedService.getVisitedSightsByUserId(userId);

            request.setAttribute("sights", sights);

            request.getRequestDispatcher("/my_places_page.jsp").forward(request, response);

        } else {
            response.sendRedirect("/ks/authorize");
        }
    }
}
