package com.galvanize.gmdb.movie.services;

import com.galvanize.gmdb.movie.entities.Movie;
import com.galvanize.gmdb.movie.repositories.MovieRepository;
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
        Optional<Movie> o =repository.findById(id);
        return o.orElse(null);
    }

    public List<Movie> findRandomMovies(int qty){
        return repository.findRandomMovies(qty);
    }
}
