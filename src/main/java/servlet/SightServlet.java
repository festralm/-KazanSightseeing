package servlet;

import dto.*;
import service.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/sight")
public class SightServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int sightId = Integer.parseInt(request.getParameter("id"));

        SightService sightService = new SightService();
        Sight sight = sightService.getSightById(sightId);
        sightService.addArchivePhotosToSight(sight);

        request.setAttribute("sight", sight);

        request.getRequestDispatcher("/sight_page.jsp").forward(request, response);
    }
}
