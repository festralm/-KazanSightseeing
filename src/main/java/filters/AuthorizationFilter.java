package filters;

import interfaces.DataAccessable;
import models.*;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Logger;

@WebFilter(filterName = "AuthorizationFilter")
public class AuthorizationFilter implements Filter {
    private static Logger logger = Logger.getLogger(AuthorizationFilter.class.getName());

    @Override
    public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain filterChain) throws IOException, ServletException {
        final HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        final HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        final String login = request.getParameter("login");
        final String password = request.getParameter("password");

        @SuppressWarnings("unchecked")
        final AtomicReference<DataAccessable> dao = (AtomicReference<DataAccessable>) httpServletRequest.getServletContext().getAttribute("dao");
        final HttpSession httpSession = httpServletRequest.getSession();

        if (CheckSession.check(httpSession, httpServletRequest)) {
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath());
        } else {
            if (dao.get().isUserExist(login, password.hashCode())) {
                LogIn.logIn(login, password, request, response, httpServletRequest, httpServletResponse);
            } else {
                httpServletRequest.getSession().setAttribute("check_password", false);
                request.getRequestDispatcher("sign_in_page.html").forward(request, response);
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