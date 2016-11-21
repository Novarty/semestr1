package Servlets;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Артем on 09.11.2016.
 */
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    static Logger log = Logger.getLogger(LogoutServlet.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.getSession().removeAttribute("user");
        req.getSession().invalidate();
        resp.sendRedirect("/main");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.getSession().removeAttribute("user");
        req.getSession().invalidate();
        log.info("'user' removed");
        resp.sendRedirect("/main");
    }
}
