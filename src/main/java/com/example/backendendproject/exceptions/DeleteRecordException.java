package com.example.backendendproject.Exceptions;

import java.io.Serial;

public class DeleteRecordException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    public DeleteRecordException() {
        super();
    }

    public DeleteRecordException(String message) {
        super(message);
    }
}

