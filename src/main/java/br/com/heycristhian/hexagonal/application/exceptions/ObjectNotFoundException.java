package br.com.heycristhian.hexagonal.application.exceptions;

public class ObjectNotFoundException extends RuntimeException {

    public ObjectNotFoundException(String msg) {
        super(msg);
    }
}
