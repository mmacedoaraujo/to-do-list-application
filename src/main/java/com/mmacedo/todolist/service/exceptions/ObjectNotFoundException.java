package com.mmacedo.todolist.service.exceptions;

public class ObjectNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 5418903305053791710L;

    public ObjectNotFoundException(String message) {
        super(message);
    }

    public ObjectNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
