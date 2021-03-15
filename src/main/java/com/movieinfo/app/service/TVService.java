package com.movieinfo.app.service;

import com.movieinfo.app.domain.TV;
import com.movieinfo.app.domain.response.TVList;
import com.movieinfo.app.domain.response.TVResponse;
import com.movieinfo.app.repository.TVRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.NotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TVService {

    public static final Logger LOGGER = LoggerFactory.getLogger(TVService.class);

    private final TVRepository repository;

    public TVService(TVRepository repository) {
        this.repository = repository;
    }

    public TVResponse findById(Integer tvDBId) {
        Optional<TV> document = repository.findByTvDBId(tvDBId);
        if(document.isPresent()) {
            LOGGER.info("Retrieving TV show with id {}", tvDBId);
            return TV.mapToResponse(document.get());
        } else {
            LOGGER.error("TV show with id {} not found", tvDBId);
            throw new NotFoundException("TV show not found with id: " + tvDBId);
        }
    }

    public TVList findAll() {
        List<TVResponse> responses =
                repository.findAll().stream().map(TV::mapToResponse).collect(Collectors.toList());
        TVList tvList = new TVList();
        tvList.setResults(responses);
        LOGGER.info("Returning all tv shows");
        return tvList;
    }

    public TVResponse insertTV(TVResponse toSave) {
        if (toSave == null) {
            LOGGER.error("Unable to insert, empty object");
            throw new BadRequestException("Document to be saved was empty");
        } else {
            LOGGER.info("Saving a new movie with id: {}", toSave.getId());
            TV document = TV.mapToDocument(toSave);
            repository.insert(document);
            return toSave;
        }
    }

    public TVResponse updateTV(Integer tvDBId, TVResponse toUpdate) {
        if (toUpdate != null) {
            if(repository.findByTvDBId(tvDBId).isPresent()) {
                LOGGER.info("Updating TV show with id {}", tvDBId);
                repository.save(TV.mapToDocument(toUpdate));
            } else {
                LOGGER.info("TV show with id {} not found, inserting in DB instead", tvDBId);
                repository.insert(TV.mapToDocument(toUpdate));
            }
            return toUpdate;
        } else {
            LOGGER.error("Object to update is null");
            throw new BadRequestException("Document to be saved was empty");
        }
    }

    public void deleteTVByDBId(Integer tvDBId) {
        LOGGER.info("Deleting TV show with id: {}", tvDBId);
        TV toDelete = repository.findByTvDBId(tvDBId).get();
        repository.deleteById(toDelete.getId());
    }
}
