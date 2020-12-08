package fr.utbm.lo54.javaweb_servlet;

import fr.utbm.lo54.entity.Movie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "movieCreationOK", urlPatterns = {"/moviecreated"})
public class MovieCreationOKServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>LO54 TP</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <h1>LO54 TP Movie created</h1>\n" +
                "The movie has been created.<br/>" +
                "<a href=\"" + request.getContextPath() + "/home.jsp\">Back to the home menu.</a>" +
                "</body>\n" +
                "</html>");

    }
}
