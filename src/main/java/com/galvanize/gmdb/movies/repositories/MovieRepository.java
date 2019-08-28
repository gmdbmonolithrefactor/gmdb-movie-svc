package com.galvanize.gmdb.movies.repositories;

import com.galvanize.gmdb.movies.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    ArrayList<Movie> findMovieByTitleContains(String criteria);
    Movie findMovieByImdbid(String imdbid);

    @Query(value = "SELECT * from movies m order by RAND() LIMIT ?1", nativeQuery = true)
    List<Movie> findRandomMovies(int qty);
}
