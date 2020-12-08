<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="fr.utbm.lo54.controller.MovieController" %>
<%@ page import="fr.utbm.lo54.entity.Movie" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: adrie
  Date: 08/12/2020
  Time: 19:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    MovieController movieController = new MovieController();
    List<Movie> movies = movieController.getMovies();
    session.setAttribute("movies", movies);
%>
<html>
<head>
    <title>LO54 TP</title>
</head>
<body>
    <h1>LO54 TP Movies list</h1>
    <ul>
        <c:forEach var="movie" items="${movies}">
            <li><a href="description.jsp?id=${movie.id}">${movie.title}</a></li>
        </c:forEach>
    </ul>
</body>
</html>
