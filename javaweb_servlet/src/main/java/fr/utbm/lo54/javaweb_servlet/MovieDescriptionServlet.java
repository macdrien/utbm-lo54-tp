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

@WebServlet(name = "movieDescription", urlPatterns = {"/description"})
public class MovieDescriptionServlet extends HttpServlet {

    private MovieController movieController;

    @Override
    public void init() throws ServletException {
        super.init();
        movieController = new MovieController();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        Movie movie = movieController.getMovie(id);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>LO54 TP</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <h1>Description of the movie " + movie.getTitle() + "</h1>\n");
        out.println("<p>The movie has " + movie.getCopies() + " copies.<br/>" +
                "It is a " + movie.getType() + " movie and the main actor is " + movie.getMainActor().getFirstname() +
                " " + movie.getMainActor().getLastname() + ".</p>" +
                "<a href=\"" + request.getContextPath() + "/list\">Return to the list</a>");

        out.println("</body>\n" +
                "</html>");
    }
}
