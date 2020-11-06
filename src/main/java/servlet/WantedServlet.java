package servlet;

import dao.interfaces.UserSightWantedDao;
import dto.Sight;
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

@WebServlet("/wanted")
public class WantedServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        final HttpSession session = request.getSession();
        if (CheckSession.checkCookie(request)) {
            int userId = (int) session.getAttribute("user_id");

            UserSightWantedService userSightWantedService = new UserSightWantedService();
            Sight[] sights = userSightWantedService.getWantedSightsByUserId(userId);

            request.setAttribute("sights", sights);

            request.getRequestDispatcher("/want_to_visit_page.jsp").forward(request, response);

        } else {
            response.sendRedirect("/ks/authorize");
        }
    }
}
