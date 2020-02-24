package ddm.controller;

import ddm.exception.DataNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionController {

    private static final String DATA_NOT_FOUND_MESSAGE = "File not found";

    @ResponseBody
    @ExceptionHandler(DataNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String dataNotFoundHandler(DataNotFoundException ex) {
        String exMessage = ex.getMessage();
        if (exMessage == null || exMessage.isEmpty()) {
            return DATA_NOT_FOUND_MESSAGE;
        }
        return exMessage;
    }
}
