package hu.simplesoft.dualis.library.web.controller.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import hu.simplesoft.dualis.library.service.exception.ServiceException;

@ControllerAdvice
public class ControllerExceptionHandler {

    private static final Logger LOGGER = LogManager.getLogger(ControllerExceptionHandler.class);
    
    @ExceptionHandler(ServiceException.class)
    public void handleServiceException(ServiceException e) {
        LOGGER.error(e);
    }
    @ExceptionHandler(RuntimeException.class)
    public void handleRuntimeException(RuntimeException e) {
        LOGGER.error(e);
    }
    @ExceptionHandler(Exception.class)
    public void handleException(Exception e) {
        LOGGER.error(e);
    }
}
