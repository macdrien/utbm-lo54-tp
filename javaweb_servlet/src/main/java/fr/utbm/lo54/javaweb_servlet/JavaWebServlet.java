package fr.utbm.lo54.javaweb_servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "home", urlPatterns = {"/home"})
public class JavaWebServlet extends HttpServlet {

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
                "    <h1>LO54 TP JavaWeb page</h1>\n" +
                "    <a href=\"" + request.getContextPath() + "/list\">Click here to go to the movies list</a><br/>\n" +
                "    <a href=\"" + request.getContextPath() + "/addMovie.html\">Create a new movie</a>\n" +
                "</body>\n" +
                "</html>");
    }
}
