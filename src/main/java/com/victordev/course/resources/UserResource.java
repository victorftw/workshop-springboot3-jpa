package com.victordev.course.resources;

import com.victordev.course.entities.User;
import com.victordev.course.services.UserService;
import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 * Represents a RESTful resource for User entities.
 * <p>
 * This class provides endpoints for retrieving user information.
 * </p>
 */

@RestController
@RequestMapping(value = "/users")
public class UserResource {

  @Autowired
  private UserService service;

  @GetMapping
  public ResponseEntity<List<User>> findAll() {
    List<User> list = service.findAll();
    return ResponseEntity.ok().body(list);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<User> findById(@PathVariable Long id) {
    User obj = service.findById(id);
    return ResponseEntity.ok().body(obj);
  }

  /**
   * Inserts a new User into the system.
   * <p>
   * This method allows for the creation of a new User entity by accepting a User object in the
   * request body. The newly created User will be returned in the response along with the location
   * URI of the newly created resource.
   * </p>
   *
   * @param obj The User object to be inserted.
   * 
   * @return A ResponseEntity containing the newly created User and the location URI of the
   *         resource.
   */

  @PostMapping
  public ResponseEntity<User> insert(@RequestBody User obj) {
    obj = service.insert(obj);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
        .buildAndExpand(obj.getId()).toUri();
    return ResponseEntity.created(uri).body(obj);
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    service.delete(id);
    return ResponseEntity.noContent().build();
  }
}
