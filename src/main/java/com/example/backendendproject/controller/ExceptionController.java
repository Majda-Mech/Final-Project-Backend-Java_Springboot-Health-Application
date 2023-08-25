package com.example.backendendproject.controller;

import com.example.backendendproject.exceptions.DeleteRecordException;
import com.example.backendendproject.exceptions.NoRelatedObjectFoundException;
import com.example.backendendproject.exceptions.RecordNotFoundException;
import com.example.backendendproject.exceptions.UpdateRecordException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(value = RecordNotFoundException.class)
    public ResponseEntity<Object> exception(RecordNotFoundException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = NoRelatedObjectFoundException.class)
    public ResponseEntity<Object> exception(NoRelatedObjectFoundException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = DeleteRecordException.class)
    public ResponseEntity<Object> exception(DeleteRecordException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = UpdateRecordException.class)
    public ResponseEntity<Object> exception(UpdateRecordException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }
}