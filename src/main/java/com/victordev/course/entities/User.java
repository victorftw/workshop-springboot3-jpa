package com.victordev.course.entities;

import java.io.Serializable;
import java.util.Objects;

/**
 * Represents a User entity.
 * <p>
 * This class defines the structure and properties of a User, including their ID, name, email,
 * phone, and password.
 * </p>
 */

public class User implements Serializable {

  private static final long serialVersionUID = 1L;

  private Long id;
  private String name;
  private String email;
  private String phone;
  private String password;

  public User() {

  }

  /**
   * Creates a new User with the specified attributes.
   *
   * @param id The ID of the user.
   * @param name The name of the user.
   * @param email The email address of the user.
   * @param phone The phone number of the user.
   * @param password The password of the user.
   */

  public User(Long id, String name, String email, String phone, String password) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.phone = phone;
    this.password = password;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    User other = (User) obj;
    return Objects.equals(id, other.id);
  }
}
