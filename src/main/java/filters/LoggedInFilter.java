package filters;

import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Артем on 04.11.2016.
 */
@WebFilter(filterName = "loggedInFilter", urlPatterns = {"/registration", "/registration.jsp", "/login", "/login.jsp"})
public class LoggedInFilter implements Filter {
    static Logger log = Logger.getLogger(LoggedInFilter.class);
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        if (((HttpServletRequest) request).getSession().getAttribute("user") == null) {
            chain.doFilter(request, response);
        } else {
            log.info("Filter: User have registrated and redirected to index.jsp");
            ((HttpServletResponse) response).sendRedirect("/index.jsp");
        }
    }

    @Override
    public void destroy() {

    }
}