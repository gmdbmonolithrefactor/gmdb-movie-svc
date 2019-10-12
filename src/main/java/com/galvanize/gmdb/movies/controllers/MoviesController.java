package com.galvanize.gmdb.movies.controllers;

import com.galvanize.gmdb.movies.entities.Movie;
import com.galvanize.gmdb.movies.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/gmdb/api/movies")
public class MoviesController {

    private MovieService service;

    @Autowired
    public MoviesController(MovieService service) {
        this.service = service;
    }

    @GetMapping("/")
    public List<Movie> searchMovies(@RequestParam(name = "search", required = false) String searchString){
        return service.search(searchString);
    }

    @GetMapping("/imdb/{imdbid}")
    public Movie getMovieByImdbId(@PathVariable String imdbid){
        return service.findMovieByImdbId(imdbid);
    }

    @GetMapping("/{id}")
    public Movie getMovieById(@PathVariable Long id){
        return service.findMovieById(id);
    }

    @GetMapping("/rand")
    public List<Movie> getRandomMovies(@RequestParam(required = false, defaultValue = "3") int qty){
        return service.findRandomMovies(qty);
    }

}
