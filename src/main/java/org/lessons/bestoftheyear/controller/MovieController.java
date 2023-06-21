package org.lessons.bestoftheyear.controller;

import org.lessons.bestoftheyear.model.Movie;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/movies")
public class MovieController {

    @GetMapping
    public String moviesPage(Model model) {
        List<Movie> bestMovies = getBestMovies();
        model.addAttribute("movieList", bestMovies);

        return "movies-page";
    }

    // pagina dettaglio movie (id preso dinamicamente dal path)
    @GetMapping("{id}")
    public String movieDetail(@PathVariable int id, Model model) {
        // recupero il Movie corrispondente all'id del path
        String title = "unknown";
        for(Movie movie : getBestMovies()) {
            if(movie.getId() == id) {
                title = movie.getTitle();
            }
        }
        model.addAttribute("movie", title);
        return "movie-detail";
    }

    private List<Movie> getBestMovies() {
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie(1, "Inception"));
        movies.add(new Movie(2, "Limitless"));
        movies.add(new Movie(3, "Interstellar"));

        return movies;
    }
}
