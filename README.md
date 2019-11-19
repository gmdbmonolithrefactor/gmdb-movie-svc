# gmdb-movies-svc

## Docker Instructions
````
$ docker build -t gmdb/movies .
$ docker run -d -p 8200:8200 --network gmdb-bridge gmdb/movies
````

## Endpoint Examples
* Search Movies: `/gmdb/api/movies/?search=title`
* Get movie by id: `/gmdb/api/movies/41`
* Get movie by imdb id: `/gmdb/api/movies/imdb/tt0991178`
* Get random movies: `/gmdb/api/movies/rand?qty=5`

