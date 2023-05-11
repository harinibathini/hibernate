package servlets;

import entities.Note;
import helper.FactoryProvider;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");
        try {
            String title = req.getParameter("title");
            String content = req.getParameter("content");
            int noteId = Integer.parseInt(req.getParameter("noteId").trim());
            Session session4 = FactoryProvider.getSessionFactory().openSession();
            Transaction transaction = session4.beginTransaction();

            Note note = session4.get(Note.class, noteId);
            note.setTitle(title);
            note.setContent(content);
            note.setAddedDate(new Date());

            transaction.commit();
            session4.close();

            resp.sendRedirect("all_notes.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
