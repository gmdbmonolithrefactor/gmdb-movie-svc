package com.galvanize.gmdb.movies;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.TestPropertySource;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations="classpath:test.properties")
public class GmdbMoviesSvcApplicationTests {

    @Test
    public void contextLoads() {
    }

}
