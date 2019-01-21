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
    public Object handleServiceException(ServiceException e) {
        String StatusResponse = "ERROR";        
        LOGGER.error(e);
        
        return StatusResponse;
    }
    @ExceptionHandler(RuntimeException.class)
    public Object handleRuntimeException(RuntimeException e) {
        String StatusResponse = "ERROR";
        LOGGER.error(e);
        
        return StatusResponse;
    }
    @ExceptionHandler(Exception.class)
    public Object handleException(Exception e) {
        String StatusResponse = "ERROR";
        LOGGER.error(e);
        
        return StatusResponse;
    }
}
