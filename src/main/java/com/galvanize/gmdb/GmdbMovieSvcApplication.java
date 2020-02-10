package com.galvanize.gmdb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class GmdbMovieSvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(GmdbMovieSvcApplication.class, args);
    }

}
