package fr.utbm.lo54;

import fr.utbm.lo54.controller.MovieController;

public class LO54TP {

    public static void main(String[] args) {

        System.out.println("LO54TP is running");

        MovieController movieController = new MovieController();
        System.out.println(movieController.getMovies());

    }
}
