package com.galvanize.gmdb.movies.repositories;

import com.galvanize.gmdb.movies.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    ArrayList<Movie> findMovieByTitleContains(String criteria);
    Movie findMovieByImdbid(String imdbid);
}
