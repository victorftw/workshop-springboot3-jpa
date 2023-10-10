package com.victordev.course.services.exceptions;

/**
 * Custom exception class to represent a database-related exception.
 */

public class DatabaseException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public DatabaseException(String msg) {
    super(msg);
  }
}
