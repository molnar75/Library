package hu.simplesoft.dualis.library.exception;


public class PersistException extends Exception {

    private static final long serialVersionUID = 1L;
    
    public PersistException (String message) {
        super (message);
    }

    public PersistException (String message, Throwable e) {
        super (message,e);
    }
}
