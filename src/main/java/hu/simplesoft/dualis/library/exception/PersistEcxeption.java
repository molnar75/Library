package hu.simplesoft.dualis.library.exception;


public class PersistEcxeption extends Exception {

    private static final long serialVersionUID = 1L;

    public PersistEcxeption (String message, Throwable e) {
        super (message,e);
    }
}
