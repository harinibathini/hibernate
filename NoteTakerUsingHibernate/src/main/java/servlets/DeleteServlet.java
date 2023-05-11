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

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");
        try{
            //title,content fetch
            int noteId = Integer.parseInt(req.getParameter("note_id").trim());

            Session session2 = FactoryProvider.getSessionFactory().openSession();
            Transaction transaction = session2.beginTransaction();
            Note note = (Note) session2.get(Note.class, noteId);
            session2.delete(note);

            transaction.commit();
            session2.close();
            resp.sendRedirect("all_notes.jsp");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
