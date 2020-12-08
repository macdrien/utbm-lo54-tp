<%--
  Created by IntelliJ IDEA.
  User: adrie
  Date: 08/12/2020
  Time: 18:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="fr.utbm.lo54.entity.Movie" %>
<%@page import="fr.utbm.lo54.controller.MovieController" %>

<%
    MovieController controller = new MovieController();
    Movie movie = controller.getMovie(Integer.parseInt(request.getParameter("id")));
    session.setAttribute("movie", movie);
%>

<html>
<head>
    <title>LO54 TP</title>
</head>
<body>
<h1>Description of the movie ${movie.title}</h1>
<p>
    The movie has ${movie.copies} copies.<br/>
    It is a ${movie.type} movie and the main actor is ${movie.mainActor.firstname} ${movie.mainActor.lastname}.
</p>
<a href="/lo54_tp/list.jsp">Return to the list</a>
</body>
</html>
