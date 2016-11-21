package Servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;

import dao.DaoFactory;
import dao.TokenDao;
import dao.UserDao;
import org.apache.log4j.Logger;
import pojo.Member;
import pojo.Token;
import pojo.User;
import pojo.UserTypes;

/**
 * Created by Артем on 25.10.2016.
 */
@WebServlet("/registration")
public class RegisterServlet extends HttpServlet {
    public static UserDao userDao = DaoFactory.getDAOFactory(1).getUserDao();
    public static final Logger log = Logger.getLogger(RegisterServlet.class);
    public static TokenDao tokenDao = DaoFactory.getDAOFactory(1).getTokenDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        log.info("regServlet is active");
        req.getRequestDispatcher("registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        ////
        log.info("Starting registering user");
        User newUser = new Member();
        log.debug("Retrieving user name from session");
        newUser.setRole(UserTypes.MEMBER.toString());
        newUser.setUsername(req.getParameter("j_username"));
        newUser.setFirstname(req.getParameter("j_firstname"));
        newUser.setLastname(req.getParameter("j_lastname"));
        //try {
        newUser.setPassword(req.getParameter("j_password"));
        log.debug("Calculating and setting password for the user");
        //} catch (NoSuchAlgorithmException e) {
        //    log.error("MD5 algorithm not fount");
        //    e.printStackTrace();
        // }

        log.debug("Saving user " + newUser.getUsername());
        try {
            userDao.create(newUser);
            newUser = userDao.read(newUser.getUsername());
            log.info("Saving user " + newUser.getUsername() + " succeed");
            //Token tk = new Token();
            //tk.setUuid(java.util.UUID.randomUUID().toString());
//            Calendar c = Calendar.getInstance();
//            c.setTime(new java.util.Date()); // Now use today date.
//            c.add(Calendar.DATE, 5);
//            java.util.Date now_plus_5_days = c.getTime();
//            tk.setDeleteDate(now_plus_5_days);
//            tk.setUser(newUser);
            //tokenDao.create(tk);
            //req.setAttribute("passwordhash", newUser.getPasswordHash());

            getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
        } catch (Exception ex) {
            log.error("Saving user " + newUser.getUsername() + " failed");
            getServletContext().getRequestDispatcher("/register.jsp").forward(req, resp);
        }
    }
}
