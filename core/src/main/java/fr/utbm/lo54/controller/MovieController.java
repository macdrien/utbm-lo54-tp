package fr.utbm.lo54.controller;

import fr.utbm.lo54.entity.Movie;
import fr.utbm.lo54.service.MovieService;

import java.io.Serializable;
import java.util.List;

public class MovieController implements Serializable {

    private final MovieService service;

    public MovieController() {
        service = new MovieService();
    }

    public List<Movie> getMovies() {
        // Get movies and parse them to JSON
        return service.getMovies();
    }

    public Movie getMovie(int id) {
        // Get movies and parse them to JSON
        return service.getMovie(id);
    }

    public Movie createMovie(String title, String type, Integer copies) {
        return service.createMovie(title, type, copies);
    }
}
