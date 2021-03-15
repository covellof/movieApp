package com.movieinfo.app.controller;

import com.movieinfo.app.domain.response.MovieResponse;
import com.movieinfo.app.domain.response.TVResponse;
import com.movieinfo.app.service.ExternalTVService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tv")
public class ExternalTVController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExternalMovieController.class);

    private ExternalTVService service;

    public ExternalTVController(ExternalTVService service) {
        this.service = service;
    }

    @GetMapping(value = "/{tvId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findTV(@PathVariable String tvId) {
        return service.getByTVId(tvId);
    }

    @GetMapping(value = "/popular")
    public ResponseEntity<?> findPopular() {
        return service.getByPopularity();
    }

    @GetMapping(value = "/{tvId}/save")
    public TVResponse fetchTVAndSave(@PathVariable String tvId) {
        TVResponse tv = (TVResponse) findTV(tvId).getBody();
        return service.saveToApi(tv);
    }

    @GetMapping(value = "/saveDBtoLocal")
    public boolean getFullDB() {
        for (int id = 1; id < 5474; id++) {
            TVResponse tv = fetchTVAndSave(String.valueOf(id));
            LOGGER.info("Saving tv show with id {}, {}", id, tv);
        }
        return true;
    }
}
