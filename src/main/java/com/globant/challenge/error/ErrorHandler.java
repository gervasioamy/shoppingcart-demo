package com.globant.challenge.error;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Global error handler for converting custom (and frameworks specific) exceptions into HTTP proper status codes.
 *
 * @author gervasio.amy
 */
@ControllerAdvice
public class ErrorHandler {

    private Logger logger = LoggerFactory.getLogger(ErrorHandler.class);

    @ResponseStatus(HttpStatus.CONFLICT)  // 409
    @ExceptionHandler(DataIntegrityViolationException.class)
    public void handleConflict(DataIntegrityViolationException e) {
        logger.info("Handling DataIntegrityViolationException -> 409");
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)  // 404
    @ExceptionHandler(NotFoundException.class)
    public void handleNotFound(NotFoundException e) {
        logger.info("Handling NotFoundException -> 404.");
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)  // 400
    @ExceptionHandler(InvalidItemReferenceException.class)
    public void handleInvalidItemReference(InvalidItemReferenceException e) {
        logger.info("Handling InvalidItemReferenceException -> 400");
    }



}
