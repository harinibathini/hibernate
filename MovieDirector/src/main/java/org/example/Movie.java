package org.example;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int movieId;
    private String movieName;
    @ManyToOne
    private Director director;
    @OneToMany(mappedBy = "movie")
    private List<Songs> songsList;

    public List<Songs> getSongsList() {
        return songsList;
    }

    public void setSongsList(List<Songs> songsList) {
        this.songsList = songsList;
    }

    public Movie() {
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public Movie(int movieId, String movieName, Director director, List<Songs> songsList) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.director = director;
        this.songsList = songsList;
    }

    //    public void setSongs(Movie movie2) {
//    }
}

