package com.epam.jwd.task.exception;

import java.util.function.Supplier;

public class FigureNotExistException extends FigureException {
    public FigureNotExistException(String message) {
        super(message);
    }
}
