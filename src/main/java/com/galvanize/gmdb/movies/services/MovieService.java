package com.galvanize.gmdb.movies.services;

import com.galvanize.gmdb.movies.entities.Movie;
import com.galvanize.gmdb.movies.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service @Component
public class MovieService {

    @Autowired
    MovieRepository repository;

    public List<Movie> search(String searchString) {
        return repository.findMovieByTitleContains(searchString);
    }

    public Movie findMovieByImdbId(String imdbId){
        return repository.findMovieByImdbid(imdbId);
    }

    public Movie findMovieById(Long id){
        return repository.findById(id).get();
    }
}
