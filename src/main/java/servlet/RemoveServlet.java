package servlet;/*
 * Created by Alexsandr        24.05.2018
 */

import dao.ImageDAO;
import dao.ImageDAOImpl;
import dao.UserDAO;
import dao.UserDAOImpl;

import entity.User;
import servis.UserService;
import servis.UserServiceImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RemoveServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
        EntityManager em = emf.createEntityManager();
        String[] id = req.getParameterValues("rem");
        UserService service = new UserServiceImpl(em);
        try {
            service.remove(id);
        } finally {
            em.close();
        }
        resp.sendRedirect("list");
    }
}
