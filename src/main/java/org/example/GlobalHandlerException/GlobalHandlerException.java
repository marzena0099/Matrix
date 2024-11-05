package org.example.GlobalHandlerException;

import org.example.TDO.ClockNameException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandlerException {



//        @ExceptionHandler(ClockNameException.class)
//        public ResponseEntity<String> handleEmployeeNotFound(ClockNameException e) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
//        }
}
