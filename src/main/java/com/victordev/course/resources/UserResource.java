package com.victordev.course.resources;

import com.victordev.course.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Represents a RESTful resource for User entities.
 * <p>
 * This class provides endpoints for retrieving user information.
 * </p>
 */

@RestController
@RequestMapping(value = "/users")
public class UserResource {

  @GetMapping
  public ResponseEntity<User> findAll() {
    User u = new User(1L, "Maria", "maria@gmail.com", "999999999", "12345");
    return ResponseEntity.ok().body(u);
  }
}
