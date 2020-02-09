package com.galvanize.gmdb.movie.controllers;

import com.galvanize.gmdb.movie.entities.Movie;
import com.galvanize.gmdb.movie.repositories.MovieRepository;
import com.galvanize.gmdb.movie.services.MovieService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest @Transactional
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@TestPropertySource(locations="classpath:test.properties")
public class MovieControllerTests {
    private static int TEST_MOVIES_COUNT = 20;
    private static String TEST_MOVIE_TITLE_PREFIX = "GMDB JUNIT TEST-";

    private List<Movie> moviesList = new ArrayList<>();

    @Autowired
    MovieService service;

    @Autowired
    MovieRepository repository;

    @Autowired
    MockMvc mvc;

    @Before
    public void setUp() {
        Movie m;
        for (int i = 1; i < TEST_MOVIES_COUNT +1; i++) {
            m = new Movie();
            m.setTitle(TEST_MOVIE_TITLE_PREFIX + (i * 13));
            m.setImdbid("im" + i * 13);
            repository.save(m);
            moviesList.add(m);
        }
    }

    @Test
    public void searchMovies() throws Exception{
        mvc.perform(get("/gmdb/api/movies/?search="+TEST_MOVIE_TITLE_PREFIX))
                .andExpect(status().isOk()).andReturn();
    }

    @Test
    public void getMovieByImdbId() throws Exception{
        mvc.perform(get("/gmdb/api/movies/imdb/"+moviesList.get(7).getImdbid()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title", is(moviesList.get(7).getTitle())))
                .andExpect(jsonPath("$.movieId", is(moviesList.get(7).getMovieId().intValue())));
    }

    @Test
    public void getMovieById() throws Exception{
        Movie testMovie = moviesList.get(3);
        mvc.perform(get(String.format("/gmdb/api/movies/%s", testMovie.getMovieId().intValue())))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.movieId", is(testMovie.getMovieId().intValue())))
                .andExpect(jsonPath("$.title", is(testMovie.getTitle())));
    }

    @Test
    public void findRandomMovies() throws Exception{
        mvc.perform(get("/gmdb/api/movies/rand?qty=2"))
               .andExpect(status().isOk());
    }
}
