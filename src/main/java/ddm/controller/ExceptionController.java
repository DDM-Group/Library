package ddm.controller;

import ddm.exception.FileNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionController {

    private static final String FILE_NOT_FOUND_MESSAGE = "File not found";

    @ResponseBody
    @ExceptionHandler(FileNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String employeeNotFoundHandler(FileNotFoundException ex) {

        String exceptionMessage = ex.getMessage();
        return ex.getMessage().isEmpty() ? FILE_NOT_FOUND_MESSAGE : exceptionMessage;
    }
}
