package fr.utbm.lo54.repository;

import fr.utbm.lo54.entity.Movie;
import lombok.NoArgsConstructor;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
public class MovieRepository implements Serializable {

    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("lo54tp");
    private EntityManager entityManager = null;

    public List<Movie> getMovies() {
        if (entityManager == null)
            entityManager = entityManagerFactory.createEntityManager();

        return entityManager.createQuery("from Movie").getResultList();
    }

    public Movie getMovie(int id) {
        if (entityManager == null)
            entityManager = entityManagerFactory.createEntityManager();

        return (Movie) entityManager.createQuery("from Movie movie where movie.id = :id")
                .setParameter("id", id).getSingleResult();
    }

    public Movie getMovieByTitle(String title) {
        if (entityManager == null)
            entityManager = entityManagerFactory.createEntityManager();

        try {
            return (Movie) entityManager.createQuery("from Movie movie where movie.title = :title")
                    .setParameter("title", title).getSingleResult();
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return null;
    }

    public boolean createMovie(Movie movie) {
        if (entityManager == null)
            entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        try {
            entityManager.persist(movie);
            entityManager.getTransaction().commit();
            return true;

        } catch (Exception exception) {
            exception.printStackTrace();
            entityManager.getTransaction().rollback();
        }

        return false;
    }
}
