package com.victordev.course.resources.exceptions;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.time.Instant;

/**
 * A standard error representation used in RESTful API responses.
 * <p>
 * This class represents a standard error structure that can be returned in responses when an error
 * occurs in a RESTful API. It includes information such as the timestamp of the error, the HTTP
 * status code, a brief error description, a detailed error message, and the path where the error
 * occurred.
 * </p>
 */

public class StandardError implements Serializable {

  private static final long serialVersionUID = 1L;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'",
      timezone = "GMT")
  private Instant timestamp;
  private Integer status;
  private String error;
  private String message;
  private String path;

  public StandardError() {

  }

  /**
   * Constructs a StandardError with the specified parameters.
   *
   * @param timestamp The timestamp when the error occurred.
   * @param status The HTTP status code associated with the error.
   * @param error A brief description of the error.
   * @param message A detailed error message providing additional information about the error.
   * @param path The path or URL where the error occurred.
   */

  public StandardError(Instant timestamp, Integer status, String error, String message,
      String path) {
    this.timestamp = timestamp;
    this.status = status;
    this.error = error;
    this.message = message;
    this.path = path;
  }

  public Instant getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Instant timestamp) {
    this.timestamp = timestamp;
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public String getError() {
    return error;
  }

  public void setError(String error) {
    this.error = error;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }
}
