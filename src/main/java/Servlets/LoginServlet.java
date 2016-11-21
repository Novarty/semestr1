package Servlets;

/**
 * Created by Артем on 25.10.2016.
 */

import dao.DaoFactory;
import dao.UserDao;
import org.apache.log4j.Logger;
import pojo.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    static Logger log = Logger.getLogger(LoginServlet.class);
    static UserDao userDao = DaoFactory.getDAOFactory(1).getUserDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        log.info("loginServlet is active");
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        String username = req.getParameter("j_username");
        String password = req.getParameter("j_password");
        //String referer = req.getHeader("Referer");
        log.info("Begin authorization");
        if (username != null) {
            if (password != null) {
                User sessionUser = userDao.read(username, password);
                if (sessionUser != null) {  // если пользователь существует
                    log.info("The user " + username + " exist and have authorized");
                    req.getSession().setAttribute("user", sessionUser);
                    resp.sendRedirect("/main");
//                    if (referer.contains("login")) {
//                        resp.sendRedirect(referer.replace("login", ""));
//                        //log.info("The referer is passed to redirect here: " + referer.replace("login", ""));
//                    } else {
//                        req.getSession().setAttribute("url", referer);
//                        resp.sendRedirect(referer.replace("login", ""));
//                        //log.info("The referer is passed to redirect here: " + referer);
//                    }
                } else {
                    log.info("The user "+ username +" not exist");
                    req.setAttribute("error", "Incorrect username or password");
                    getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
                }

            } else {
                log.info("Password was not passed");
                req.setAttribute("error", "Username or password was not passed");
                getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
            }
        } else {
            log.info("Username was not passed");
            req.setAttribute("error", "Username or password was not passed");
            getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }
}
