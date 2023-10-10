package com.victordev.course.services.exceptions;

/**
 * Exception indicating that a requested resource was not found.
 * <p>
 * This exception is thrown to indicate that a requested resource, identified by a specific
 * identifier (id), was not found in the system. The exception message includes the id of the
 * resource that was not found.
 * </p>
 */

public class ResourceNotFoundException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public ResourceNotFoundException(Object id) {
    super("Resource not found. Id " + id);
  }
}
