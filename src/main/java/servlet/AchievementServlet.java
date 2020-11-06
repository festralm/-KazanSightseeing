package servlet;

import dto.Achievement;
import dto.User;
import service.AchievementService;
import service.UserService;
import useful.CheckSession;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/achievements")
public class AchievementServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        final HttpSession session = request.getSession();
        ServletContext servletContext = getServletContext();
        if (CheckSession.checkCookie(request)) {

            int userId = (int) session.getAttribute("user_id");

            AchievementService achievementService = new AchievementService();
            Achievement[] achievements = achievementService.getAchievementsByUserId(userId);

            request.setAttribute("achievements", achievements);

            request.getRequestDispatcher("/achievements_page.jsp").forward(request, response);

        } else {
            response.sendRedirect("/ks/authorize");
        }
    }
}
