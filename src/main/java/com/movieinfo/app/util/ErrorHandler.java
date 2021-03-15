package com.movieinfo.app.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

import javax.ws.rs.NotFoundException;
import java.io.IOException;
import java.rmi.NoSuchObjectException;
import java.rmi.ServerError;

import static org.springframework.http.HttpStatus.Series.CLIENT_ERROR;
import static org.springframework.http.HttpStatus.Series.SERVER_ERROR;

public class ErrorHandler implements ResponseErrorHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(ErrorHandler.class);

    @Override
    public boolean hasError(ClientHttpResponse clientHttpResponse) throws IOException {
        LOGGER.info("Request status: {}, {}", clientHttpResponse.getStatusCode(), clientHttpResponse.getStatusText());
        return (clientHttpResponse.getStatusCode().series() == CLIENT_ERROR
                        || clientHttpResponse.getStatusCode().series() == SERVER_ERROR);
    }

    @Override
    public void handleError(ClientHttpResponse clientHttpResponse) throws IOException {
        if (clientHttpResponse.getStatusCode().series() == SERVER_ERROR) {
            // handle SERVER_ERROR
            LOGGER.error("Internal server error: {}", clientHttpResponse.getStatusText());
            throw new ServerError("Internal server error", new Error("Internal Server Error"));
        } else if (clientHttpResponse.getStatusCode().series() == CLIENT_ERROR) {
            // handle CLIENT_ERROR
            LOGGER.error("Client side error: {}", clientHttpResponse.getStatusText());
            if (clientHttpResponse.getStatusCode() == HttpStatus.NOT_FOUND) {
                LOGGER.error("Movie not found");
            }
        }
    }
}
