package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        //System.out.println( "Hello World!" );
        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Question question = new Question();
        question.setQuestion("What is Java?");

        Answer answer = new Answer();
        answer.setAnswer("Java is a programming language");

        question.setAnswer(answer);
        answer.setQuestion(question);

        Question question1 = new Question();
        question1.setQuestion("What is Collection?");

        Answer answer1 = new Answer();
        answer1.setAnswer("API to work with group of Objects");

        question1.setAnswer(answer1);
        answer1.setQuestion(question1);

        Question question2 = new Question();
        question2.setQuestion("What is Netbeans?");

        Answer answer2 = new Answer();
        answer2.setAnswer("IDE for writing codes");

        question2.setAnswer(answer2);
        answer2.setQuestion(question2);

        session.save(question1);
        session.save(answer1);
        session.save(question2);
        session.save(answer2);
        session.save(question);
        session.save(answer);

        transaction.commit();
        session.close();

        //fetching
//        Question q = (Question) session.get(Question.class, 1);
//        System.out.println(q.getQuestionId());
//        System.out.println(q.getQuestion());
//        System.out.println(q.getAnswer());

        System.out.println("_______________________");
        System.out.println(question.getQuestionId());
        System.out.println(question.getQuestion());
        System.out.println(question.getAnswer());
        System.out.println("_______________________");

        System.out.println("_______________________");
        System.out.println(answer1.getAnswerId());
        System.out.println(answer1.getAnswer());
        System.out.println(answer1.getQuestion());
        System.out.println("_______________________");
    }
}
