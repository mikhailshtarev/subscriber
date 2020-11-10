package ru.shtarev.subscriber.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ru.shtarev.subscriber.entity.ExceptionsResponce;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ExceptionControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
        return  new ResponseEntity<>(ExceptionsResponce.builder().status(HttpStatus.BAD_REQUEST)
                .time(LocalDateTime.now())
                .message(ex.getMessage())
                .debugMessage(request.getDescription(false)),HttpStatus.BAD_REQUEST);
    }
}
