package org.example;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Director {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int directorId;
    private String directorName;
    @OneToMany(mappedBy = "director")
    private Set<Movie> movies;

    public Director() {
    }

    public int getDirectorId() {
        return directorId;
    }

    public void setDirectorId(int directorId) {
        this.directorId = directorId;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }

    public Director(int directorId, String directorName, Set<Movie> movies) {
        this.directorId = directorId;
        this.directorName = directorName;
        this.movies = movies;
    }
}

