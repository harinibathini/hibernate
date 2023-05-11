package org.example;

import javax.persistence.*;

@Entity
public class Songs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int songId;
    private String songName;
    @ManyToOne
    private Movie movie;

    public Songs() {
    }

    public Songs(int songId, String songName, Movie movie) {
        this.songId = songId;
        this.songName = songName;
        this.movie = movie;
    }

    public int getSongId() {
        return songId;
    }

    public void setSongId(int songId) {
        this.songId = songId;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    @Override
    public String toString() {
        return "Songs{" +
                "songId=" + songId +
                ", songName='" + songName + '\'' +
                ", movie=" + movie +
                '}';
    }
}
