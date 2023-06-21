package org.lessons.bestoftheyear.controller;

import org.lessons.bestoftheyear.model.Movie;
import org.lessons.bestoftheyear.model.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/songs")
public class SongController {

    @GetMapping
    public String songsPage(Model model) {
        List<Song> bestSongs = getBestSongs();
        model.addAttribute("songList", bestSongs);

        return "songs-page";
    }

    // pagina dettaglio song (id preso dinamicamente dal path)
    @GetMapping("{id}")
    public String songDetail(@PathVariable int id, Model model) {
        // recupero il Movie corrispondente all'id del path
        String title = "unknown";
        for(Song song : getBestSongs()) {
            if(song.getId() == id) {
                title = song.getTitle();
            }
        }
        model.addAttribute("song", title);
        return "song-detail";
    }

    private List<Song> getBestSongs() {
        List<Song> songs = new ArrayList<>();
        songs.add(new Song(1, "Song for someone"));
        songs.add(new Song(2, "A sky full of stars"));
        songs.add(new Song(3, "Time is running out"));

        return songs;
    }
}
