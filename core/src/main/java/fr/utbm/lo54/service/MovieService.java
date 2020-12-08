package fr.utbm.lo54.service;

import fr.utbm.lo54.entity.Movie;
import fr.utbm.lo54.repository.MovieRepository;
import java.io.Serializable;
import java.util.List;

public class MovieService implements Serializable {

    private final MovieRepository repository;

    public MovieService() {
        repository = new MovieRepository();
    }

    public List<Movie> getMovies() {
        return repository.getMovies();
    }

    public Movie getMovie(int id) { return repository.getMovie(id); }

    public Movie getMovieByTitle(String title) { return repository.getMovieByTitle(title); }

    public Movie createMovie(String title, String type, Integer copies) {
        if (getMovieByTitle(title) != null)
            return null;

        return repository.createMovie(new Movie(null, title, copies, type, null, null)) ?
                getMovieByTitle(title) :
                null;
    }
}
