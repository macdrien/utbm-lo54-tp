package fr.utbm.lo54.javaweb_servlet;

import fr.utbm.lo54.controller.MovieController;
import fr.utbm.lo54.entity.Movie;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet(name = "addMovie", urlPatterns = {"/addmovie"})
public class MovieCreateServlet extends HttpServlet {

    private MovieController movieController;

    @Override
    public void init() throws ServletException {
        super.init();
        movieController = new MovieController();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> form = request.getParameterMap();
        String title = form.get("title")[0],
                type = form.get("type")[0];
        Integer copies = Integer.parseInt(form.get("copies")[0]);

        Movie movie = movieController.createMovie(title, type, copies);

        response.sendRedirect("/lo54_tp/" + (movie != null ? "moviecreated" : "movienotcreated"));
    }
}
