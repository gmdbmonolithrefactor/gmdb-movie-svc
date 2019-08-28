package com.galvanize.gmdb.movies.services;

import com.galvanize.gmdb.movies.entities.Movie;
import com.galvanize.gmdb.movies.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service @Component
public class MovieService {


    private MovieRepository repository;

    @Autowired
    public MovieService(MovieRepository repository) {
        this.repository = repository;
    }

    public List<Movie> search(String searchString) {
        return repository.findMovieByTitleContains(searchString);
    }

    public Movie findMovieByImdbId(String imdbId){
        return repository.findMovieByImdbid(imdbId);
    }

    public Movie findMovieById(Long id){
        Optional o =repository.findById(id);
        return o.isPresent() ? (Movie)o.get() : null;
    }

    public List<Movie> findRandomMovies(int qty){
        return repository.findRandomMovies(qty);
    }
}
