import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/AddProductServlet")
public class AddProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();


        HttpSession session1 = req.getSession();

        int idCus = (int) session1.getAttribute("cid");

        System.out.println(idCus);

        String name = req.getParameter("name");
        int price = Integer.parseInt(req.getParameter("price"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));

        int totalbill = price*quantity;

        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setQuantity(quantity);
        product.setTotalbill(totalbill);


        List<Product> list= new ArrayList<>();
        list.add(product);

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Customer customer = session.get(Customer.class,idCus);
        customer.setProducts(list);

        product.setCustomer(customer);

        session.save(product);
        session.save(customer);

        transaction.commit();
        session.close();

        resp.sendRedirect("customerLogin.html");

    }
}
