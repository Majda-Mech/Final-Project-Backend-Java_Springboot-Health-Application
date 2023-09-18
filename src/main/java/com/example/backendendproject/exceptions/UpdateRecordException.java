package com.example.backendendproject.Exceptions;

import java.io.Serial;

public class UpdateRecordException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    public UpdateRecordException() {
        super();
    }

    public UpdateRecordException(String message) {
        super(message);
    }
}
