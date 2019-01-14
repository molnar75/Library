package hu.simplesoft.dualis.library.service.exception;


public class ServiceException extends Exception {

    private static final long serialVersionUID = 1L;

    public ServiceException (Throwable e) {
        super (e);
    }
}
