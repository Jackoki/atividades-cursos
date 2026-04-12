package adopet.api.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AdocaoException.class)
    public ResponseEntity<ResponseError> adocaoeException(AdocaoException ex){
        ResponseError response = new ResponseError(ex.getMessage(), HttpStatus.BAD_REQUEST, LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

}
