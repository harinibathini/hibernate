package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        Configuration configuration = new Configuration().configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Director director = new Director();
        director.setDirectorId(1);
        director.setDirectorName("Neel");

        //director.setMovies("Kgf","Salaar");
        Movie movie = new Movie();
        movie.setMovieId(1);
        movie.setMovieName("Kgf");
        movie.setDirector(director);

        Movie movie1 = new Movie();
        movie1.setMovieId(2);
        movie1.setMovieName("Salaar");
        movie1.setDirector(director);

        Set<Movie> movies = new HashSet<Movie>();

        movies.add(movie);
        movies.add(movie1);
        director.setMovies(movies);

        session.save(movie);
        session.save(movie1);
        session.save(director);



        Movie movie2 = new Movie();
        movie2.setMovieId(3);
        movie2.setMovieName("Sitaramam");

        Songs songs = new Songs();
        songs.setSongId(1);
        songs.setSongName("Oh sita");
        songs.setMovie(movie2);

        Songs songs1 = new Songs();
        songs1.setSongId(2);
        songs1.setSongName("ram");
        songs1.setMovie(movie2);

        List<Songs> songsList = new ArrayList<Songs>();
        songsList.add(songs);
        songsList.add(songs1);
        movie2.setSongsList(songsList);

        session.save(songs);
        session.save(songs1);
        session.save(movie2);

        transaction.commit();
        session.close();

    }
}
