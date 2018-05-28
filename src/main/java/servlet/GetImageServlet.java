package servlet;/*
 * Created by Alexsandr        24.05.2018
 */

import dao.ImageDAO;
import dao.ImageDAOImpl;
import dao.UserDAO;
import dao.UserDAOImpl;
import entity.Image;
import entity.User;
import servis.UserService;
import servis.UserServiceImpl;

import javax.jws.soap.SOAPBinding;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public class GetImageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
        EntityManager em = emf.createEntityManager();
        Long id = Long.valueOf(req.getParameter("id"));

        UserService service = new UserServiceImpl(em);
        try {
            User user = service.getUser(id);
            OutputStream stream = resp.getOutputStream();
            try {
                stream.write(user.getImage().getImage());
            } finally {
                stream.close();
            }
        } finally {
            em.close();
        }
    }
}
