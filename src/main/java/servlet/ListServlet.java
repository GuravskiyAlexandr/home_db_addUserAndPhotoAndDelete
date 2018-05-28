package servlet;

import dao.ImageDAO;
import dao.ImageDAOImpl;
import dao.UserDAO;
import dao.UserDAOImpl;
import entity.Image;
import entity.User;
import servis.UserService;
import servis.UserServiceImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.RequestDispatcher;
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

public class ListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
        EntityManager em = emf.createEntityManager();
        UserService service = new UserServiceImpl(em);
        try {
            List<User> users = service.getAll();
            req.setAttribute("users", users);
        } finally {
            em.close();
        }

        RequestDispatcher dispatcher = getServletContext()
                .getRequestDispatcher("/result.jsp");
        dispatcher.forward(req, resp);
    }
}
