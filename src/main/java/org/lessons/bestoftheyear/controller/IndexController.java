package org.lessons.bestoftheyear.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller // con l'annotation @ specifico a Spring che questa classe è un controller
@RequestMapping("/") // la rotta a cui rispondono i metodi di questo controller
public class IndexController {

    @GetMapping // specifico che il metodo risponde alle richieste di tipo http GET
    // Per inserire un parametro che può essere dinamico: chiediamo a Spring di invocare questo metodo passandogli il Model
    public String home(Model model) {
        String name = "Stefano";
        model.addAttribute("name", name); // aggiungo alla mappa del Model un attributo

        return "index"; // ritorno il nome del template index.html che si trova nella cartella resources/templates
    }

    @GetMapping("/movies")
    public String moviesPage(Model model) {
        List<Movie> bestMovies = getBestMovies();
        String strMovies = "";
        for (Movie movie : bestMovies) {
            if(!strMovies.isBlank()) {
                strMovies += ", "; // aggiungo virgola e spazio solamente se la stringa non è vuota
            }
            strMovies += movie.getId() + ") " + movie.getTitle(); // aggiungo id e titolo successivamente in modo da avere l'ultimo elemento della stringa senza virgola
        }
        model.addAttribute("movies", strMovies);

        return "movies-page";
    }

    @GetMapping("/songs")
    public String songsPage(Model model) {
        List<Song> bestSongs = getBestSongs();
        String strSongs = "";
        for (Song song : bestSongs) {
            if(!strSongs.isBlank()) {
                strSongs += ", "; // aggiungo virgola e spazio solamente se la stringa non è vuota
            }
            strSongs += song.getId() + ") " + song.getTitle(); // aggiungo id e titolo successivamente in modo da avere l'ultimo elemento della stringa senza virgola
        }
        model.addAttribute("songs", strSongs);

        return "songs-page";
    }

    private List<Movie> getBestMovies() {
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie(1, "Inception"));
        movies.add(new Movie(2, "Limitless"));
        movies.add(new Movie(3, "Interstellar"));

        return movies;
    }
    private List<Song> getBestSongs() {
        List<Song> songs = new ArrayList<>();
        songs.add(new Song(1, "Song for someone"));
        songs.add(new Song(2, "A sky full of stars"));
        songs.add(new Song(3, "Time is running out"));

        return songs;
    }

}
