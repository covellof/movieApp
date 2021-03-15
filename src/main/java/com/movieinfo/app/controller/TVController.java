package com.movieinfo.app.controller;

import com.movieinfo.app.domain.response.TVList;
import com.movieinfo.app.domain.response.TVResponse;
import com.movieinfo.app.service.TVService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tv")
public class TVController {

    private final TVService service;

    public TVController(TVService service) {
        this.service = service;
    }

    @GetMapping("/")
    public TVList findAll() {
        return service.findAll();
    }

    @GetMapping("{tvDBId}")
    public TVResponse findById(@PathVariable Integer tvDBId) {
        return service.findById(tvDBId);
    }

    @PostMapping("/")
    public TVResponse save(@RequestBody TVResponse toSave) {
        return service.insertTV(toSave);
    }

    @PutMapping("/{tvDBId}")
    public TVResponse update(@PathVariable Integer tvDBId, @RequestBody TVResponse toUpdate) {
        return service.updateTV(tvDBId, toUpdate);
    }

    @DeleteMapping("{tvDBId}")
    public void delete(@PathVariable Integer tvDBId) {
        service.deleteTVByDBId(tvDBId);
    }
}
