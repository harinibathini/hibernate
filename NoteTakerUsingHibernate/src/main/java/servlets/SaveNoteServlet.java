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

@WebServlet("/SaveNoteServlet")
public class SaveNoteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");
        try{
          //title,content fetch
            String title = req.getParameter("title");
            String content = req.getParameter("content");

            Note note = new Note(title,content,new Date());
            //System.out.println(note.getId() +" : "+note.getTitle());

            //hibernate:save
            Session session = FactoryProvider.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.save(note);
            transaction.commit();
            session.close();
            //out.println("<h1>Note is added successfully</h1>");
            out.println("<h1 style='text-align:center;'>Note is added successfully</h1>");
           out.println("<h1 style='text-align:center;'><a href='all_notes.jsp'>View All Notes</a></h1>");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
