package filters;

import models.CheckSession;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "GlobalFilter")
public class GlobalFilter implements Filter {
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        final HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        final HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        final HttpSession session = httpServletRequest.getSession();

        if (CheckSession.check(session, httpServletRequest)) {
            request.getRequestDispatcher("/home_page.html").forward(request, response);
        } else {
            request.getRequestDispatcher("/welcome_page.html").forward(request, response);
        }
    }

    public void destroy() {

    }

    public void init(FilterConfig config) throws ServletException {

    }
}
