package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class App1toM {
    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Question1toM question1 = new Question1toM();
        question1.setQuestionId(1);
        question1.setQuestion("What is Java?");

         Answer1toM answer1 = new Answer1toM();
         answer1.setAnswerId(1);
         answer1.setAnswer("Java is a Programming language");
         answer1.setQuestion1toM(question1);

         Answer1toM answer2 = new Answer1toM();
         answer2.setAnswerId(2);
         answer2.setAnswer("It is used to develop softwares");
         answer2.setQuestion1toM(question1);

         Answer1toM answer3 = new Answer1toM();
         answer3.setAnswerId(3);
         answer3.setAnswer("it has many frameworks");
         answer3.setQuestion1toM(question1);

        List<Answer1toM> list1 = new ArrayList<Answer1toM>();
        list1.add(answer1);
        list1.add(answer2);
        list1.add(answer3);

        question1.setAnswer1toM(list1);

        session.save(question1);
        session.save(answer1);
        session.save(answer2);
        session.save(answer3);

//      fetching
        Question1toM q = (Question1toM) session.get(Question1toM.class, 1);
        System.out.println(q.getQuestion());
        for(Answer1toM a : q.getAnswer1toM()){
            System.out.println(a.getAnswer());
        }

        transaction.commit();
        session.close();
    }
}
