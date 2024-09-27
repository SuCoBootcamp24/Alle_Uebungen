package de.supercode.eshop.exeptions;

public class InsufficientQuantityException extends RuntimeException {

    // Konstruktor ohne Parameter
    public InsufficientQuantityException() {
        super("Insufficient quantity for the requested article.");
    }
}
