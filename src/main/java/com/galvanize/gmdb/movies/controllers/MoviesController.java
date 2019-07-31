package com.galvanize.gmdb.movies.controllers;

import com.galvanize.gmdb.movies.entities.Movie;
import com.galvanize.gmdb.movies.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gmdb/api/movies")
public class MoviesController {
    @Autowired
    MovieService service;

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


}
