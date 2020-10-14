package filters;

import models.*;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Logger;

@WebFilter(filterName = "RegistrationFilter")
public class RegistrationFilter implements Filter {
    private static Logger logger = Logger.getLogger(RegistrationFilter.class.getName());

    @Override
    public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain filterChain) throws IOException, ServletException {
        final HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        final HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        final String login = request.getParameter("login");
        final String password = request.getParameter("password");

        @SuppressWarnings("unchecked")
        final AtomicReference<UserDAO> dao = (AtomicReference<UserDAO>) httpServletRequest.getServletContext().getAttribute("dao");

        final HttpSession session = httpServletRequest.getSession();

        if (CheckSession.check(session, httpServletRequest)) {
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath());
        } else {
            if (!dao.get().isLoginExist(login)) {
                dao.get().add(new User(dao.get().getStoreSize(), login, password));
                LogIn.logIn(login, password, request, response, httpServletRequest, httpServletResponse);
            } else {
                httpServletRequest.getSession().setAttribute("check_login", false);
                request.getRequestDispatcher("/registration_page.html").forward(request, response);
            }
        }
    }

    @Override
    public void destroy() {

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }
}