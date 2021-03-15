package com.movieinfo.app.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.movieinfo.app.domain.response.MovieList;
import com.movieinfo.app.domain.response.MovieResponse;
import com.movieinfo.app.util.ErrorHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.ws.rs.BadRequestException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@Service
public class ExternalMovieService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExternalMovieService.class);
    private final RestTemplate template;
    private final ObjectMapper mapper;
    private static final String ENDPOINT = "movie";
    private final MovieService service;

    @Value("${moviedb.api.url}")
    private String MOVIE_URL;

    @Value("${moviedb.api.key}")
    private String API_KEY;

    public ExternalMovieService(RestTemplateBuilder restTemplateBuilder, MovieService service) {
        this.service = service;
        ErrorHandler errorHandler = new ErrorHandler();
        this.template = restTemplateBuilder
                .errorHandler(errorHandler)
                .build();
        this.mapper = new ObjectMapper();
    }

    public ResponseEntity<?> getByMovieId(String movieId) {
        LOGGER.info("Getting movie by id number: {}", movieId);
        URI uri = buildUri(movieId);
        LOGGER.info("Performing request on uri: {}", uri);
        String response = performRestServiceCall(uri);
        try {
            MovieResponse movieResponse = mapper.readValue(response, MovieResponse.class);
            return new ResponseEntity<>(movieResponse, HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("Error Processing Json: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<?> getByPopularity() {
        LOGGER.info("Getting movies by popularity");
        URI uri = buildUri("popular");
        LOGGER.info("Performing request on uri: {}", uri);
        String response = performRestServiceCall(uri);
        try {
            MovieList moviesResponse = mapper.readValue(response, MovieList.class);
            return new ResponseEntity<>(moviesResponse, HttpStatus.OK);
        } catch (JsonProcessingException e) {
            LOGGER.error("Error Processing Json: {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    private String performRestServiceCall(URI uri) {
            String response = template.getForObject(uri, String.class);
            LOGGER.info("Response Object: " + response);
            return response;
    }

    private URI buildUri(String identifier) {
        Map<String, String> params = new HashMap<>();
        params.put("endpoint", ENDPOINT);
        params.put("identifier", identifier);
        URI uri = UriComponentsBuilder.fromUriString(MOVIE_URL)
                .buildAndExpand(params)
                .toUri();
        uri = UriComponentsBuilder
                .fromUri(uri)
                .queryParam("api_key", API_KEY)
                .build()
                .toUri();
        return uri;
    }

    public MovieResponse saveToApi(MovieResponse toSave) {
        if(toSave != null) {
            LOGGER.info("Saving movie to database with id {}", toSave.getId());
            return service.insertMovie(toSave);
        } else {
            LOGGER.error("There was a problem saving object to DB");
            throw new BadRequestException("There was a problem saving object to DB");
        }
    }
}
