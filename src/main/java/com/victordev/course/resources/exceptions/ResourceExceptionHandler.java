package com.victordev.course.resources.exceptions;

import com.victordev.course.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import java.time.Instant;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Global exception handler for handling custom exceptions in RESTful API controllers.
 * <p>
 * This class is annotated with `@ControllerAdvice`, making it a global exception handler for all
 * controllers in the application. It provides methods to handle specific exceptions and return
 * appropriate error responses, such as when a resource is not found.
 * </p>
 */

@ControllerAdvice
public class ResourceExceptionHandler {

  /**
   * Handle the `ResourceNotFoundException` and return a response with an appropriate error message.
   *
   * @param e The `ResourceNotFoundException` that occurred.
   * @param request The HTTP servlet request.
   * @return A `ResponseEntity` containing a `StandardError` response with details about the error.
   */

  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e,
      HttpServletRequest request) {
    String error = "Resource not found";
    HttpStatus status = HttpStatus.NOT_FOUND;
    StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(),
        request.getRequestURI());
    return ResponseEntity.status(status).body(err);
  }

}
