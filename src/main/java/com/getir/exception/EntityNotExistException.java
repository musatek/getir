package com.getir.exception;

public class EntityNotExistException extends RuntimeException {

    public EntityNotExistException() {
        super();
    }

    public EntityNotExistException(String id) {
        super("Entity not found for id: " + id);
    }
}
