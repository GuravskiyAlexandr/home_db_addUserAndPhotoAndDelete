package servlet;
/*
Написать веб приложение, которое позволит ввести информацию о клиенте и добавить его фотографию.
 Фото и данные лежат в разных таблицах. После добавления записи в браузере отображается таблица
 со всеми ранее добавленными данными и preview фотографий. Напротив каждой строки в таблице checkbox
 . Есть возможность выбрать N записей и одним нажатием кнопки Delete удалить их из базы.
 */

import servis.UserService;
import servis.UserServiceImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;


@MultipartConfig
public class AddServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        add(true, req, resp);
    }

    private void add(boolean redirect,
                     HttpServletRequest req,
                     HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String age = req.getParameter("age");
        InputStream imageStream = req.getPart("image").getInputStream();

        EntityManagerFactory emf = (EntityManagerFactory) getServletContext().getAttribute("emf");
        EntityManager em = emf.createEntityManager();

        UserService userService = new UserServiceImpl(em);
        try {
            redirect = userService.add(name, age, imageStream);
        } finally {
            em.close();
        }
        if (redirect) {
            resp.sendRedirect("list");
        } else {
            resp.sendRedirect("index.jsp");
        }
    }
}
