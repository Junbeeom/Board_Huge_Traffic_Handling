package com.fastcampus.Board_Huge_Traffic_Handling.exception.handler;

import com.fastcampus.Board_Huge_Traffic_Handling.dto.response.CommonResponse;
import com.fastcampus.Board_Huge_Traffic_Handling.exception.BoardServerException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<Object> handleRuntimeExceptionException(RuntimeException ex) {
        CommonResponse commonResponse = new CommonResponse(HttpStatus.OK, "RuntimeException", ex.getMessage(), ex.getMessage());
        return new ResponseEntity<>(commonResponse, new HttpHeaders(), commonResponse.getStatus());
    }

    @ExceptionHandler({BoardServerException.class})
    public ResponseEntity<Object> handleBoardServerException(BoardServerException ex) {
        CommonResponse commonResponse = new CommonResponse(HttpStatus.OK, "BoardServerException", ex.getMessage(), ex.getMessage());
        return new ResponseEntity<>(commonResponse, new HttpHeaders(), commonResponse.getStatus());
    }

    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    protected ResponseEntity<Object> handleException(Exception ex) {
        CommonResponse commonResponse = new CommonResponse(HttpStatus.OK, "Exception", ex.getMessage(), ex.getMessage());
        return new ResponseEntity<>(commonResponse, new HttpHeaders(), commonResponse.getStatus());
    }

}
