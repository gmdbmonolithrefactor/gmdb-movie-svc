# gmdb-movie-svc
Reference implementation for the movie service, for the gMDb Monolith Refactor exercise.

## Configuration: Environment Variables
* EUREKA_CLIENT_ENABLED=false  # Default
* EUREKA_HOST=gmdb-discovery:8761  
* DB_HOST_AND_PORT=localhost:3306 # Default 
* DB_USER=gmdb #Default
* DB_PWD=someGoodSecret

## Endpoint Examples
* All Movies: `/gmdb/api/movies`
* Search Movies: `/gmdb/api/movies?search=title`
* Get movie by id: `/gmdb/api/movies/41`
* Get movie by imdb id: `/gmdb/api/movies/imdb/tt0991178`
* Get random movies: `/gmdb/api/movies/rand?qty=5`
* Get random movies default qty=3: `/gmdb/api/movies/rand`

## Docker Instructions
````
$ docker build -t gmdb/movies .

$ docker run -d -p 8200:8080 \
        -e EUREKA_CLIENT_ENABLED=true \
        -e EUREKA_HOST=gmdb-discovery:8761 \ 
        -e DB_HOST_AND_PORT=gmdb-devdb:3306 \
        -e DB_USER=gmdb \
        -e DB_PWD=someGoodSecret \
        --network gmdb-bridge \
        gmdb/movies
```` 

## PCF Instructions
1. Build project as normal `$ ./gradlew clean build`
1. Push from root directory `$ cf push`

NOTE: Requires a mysql database service named gmdb-devdb (ex: ClearDb MySQL Database free-spark DB, ).  Name of service can be changed on command line, or in the included manifest.yml. 



