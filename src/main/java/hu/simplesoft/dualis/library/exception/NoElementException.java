package hu.simplesoft.dualis.library.exception;


public class NoElementException extends PersistException {
    
    private static final long serialVersionUID = 1L;

    public NoElementException (String message, Throwable e) {
        super (message,e);
    }

}
