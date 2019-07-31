package com.galvanize.gmdb.movies.services;

import com.galvanize.gmdb.movies.entities.Movie;
import com.galvanize.gmdb.movies.repositories.MovieRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@SpringBootTest @Transactional
@RunWith(SpringRunner.class)
public class MovieServiceTests {
    public static int TEST_MOVIES_COUNT = 20;
    public static String TEST_MOVIE_TITLE_PREFIX = "GMDB JUNIT TEST-";

    List<Movie> moviesList = new ArrayList<>();


    @Autowired
    MovieRepository repository;

    @Autowired
    MovieService service;

    @Before
    public void setUp() throws Exception {
        Movie m = null;
        for (int i = 1; i < TEST_MOVIES_COUNT +1; i++) {
            m = new Movie();
            m.setTitle(TEST_MOVIE_TITLE_PREFIX +(i*13));
            m.setImdbid("im"+i*13);
            repository.save(m);
            moviesList.add(m);

        }
    }

    @Test
    public void searchMovies() {
        List<Movie> movies = service.search(TEST_MOVIE_TITLE_PREFIX);
        assertEquals(TEST_MOVIES_COUNT, movies.size());
        assertTrue(movies.get(TEST_MOVIES_COUNT /2).getTitle().startsWith(TEST_MOVIE_TITLE_PREFIX));
    }

    @Test
    public void findByImdbId() {
        Movie testMovie = moviesList.get(13);
        Movie m = service.findMovieByImdbId(testMovie.getImdbid());
        assertEquals(testMovie.getTitle(), m.getTitle());
        assertEquals(testMovie.getImdbid(), m.getImdbid());
        assertEquals(testMovie.getMovieId(), m.getMovieId());



    }
}
