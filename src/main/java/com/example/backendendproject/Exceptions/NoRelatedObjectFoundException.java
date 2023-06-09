package com.example.backendendproject.Exceptions;

import java.io.Serial;

public class NoRelatedObjectFoundException extends RuntimeException {

        @Serial
        private static final long serialVersionUID = 1L;

        public NoRelatedObjectFoundException() {
            super();
        }

        public NoRelatedObjectFoundException(String message) {
            super(message);}
}

