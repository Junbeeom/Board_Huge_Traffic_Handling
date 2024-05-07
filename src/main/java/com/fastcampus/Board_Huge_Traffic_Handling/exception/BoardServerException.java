package com.fastcampus.Board_Huge_Traffic_Handling.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
@Setter
public class BoardServerException extends RuntimeException {
    HttpStatus code;
    String msg;

}
