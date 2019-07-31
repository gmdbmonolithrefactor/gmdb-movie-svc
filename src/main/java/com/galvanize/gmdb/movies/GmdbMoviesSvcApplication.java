package com.galvanize.gmdb.movies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class GmdbMoviesSvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(GmdbMoviesSvcApplication.class, args);
    }

}
