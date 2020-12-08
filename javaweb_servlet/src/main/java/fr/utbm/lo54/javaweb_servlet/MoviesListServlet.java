package fr.utbm.lo54.javaweb_servlet;

import fr.utbm.lo54.controller.MovieController;
import fr.utbm.lo54.entity.Movie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "moviesList", urlPatterns = {"/list"})
public class MoviesListServlet extends HttpServlet {

    private MovieController movieController;

    @Override
    public void init() throws ServletException {
        super.init();
        movieController = new MovieController();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Movie> movies = movieController.getMovies();
        if (movies == null)
            System.out.println("null movies");
        else
            System.out.println(movies);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>LO54 TP</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <h1>LO54 TP Movies list</h1>\n");
        out.println("<ul>\n");
        movies.forEach(movie -> out.println(
                "<a href=\"" + request.getContextPath() + "/description.jsp?id=" + movie.getId() + "\">" +
                    "<li> " + movie.getTitle() + "</li>" +
                "</a>\n"));
        out.println("</ul>\n");

        out.println("</body>\n" +
                "</html>");
    }
}
