package com.victordev.course.services;

import com.victordev.course.entities.User;
import com.victordev.course.repositories.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service class for handling user-related operations.
 */

@Service
public class UserService {

  @Autowired
  private UserRepository repository;

  public List<User> findAll() {
    return repository.findAll();
  }

  public User findById(Long id) {
    Optional<User> obj = repository.findById(id);
    return obj.get();
  }

  public User insert(User obj) {
    return repository.save(obj);
  }

  public void delete(Long id) {
    repository.deleteById(id);
  }

  /**
   * Updates an existing User entity by its unique identifier.
   * 
   * <p>
   * This method allows for the modification of an existing User entity identified by its unique
   * identifier. The modified User entity is returned as a result of the update.
   * </p>
   *
   * @param id The unique identifier of the User entity to be updated.
   * 
   * @param obj The User object containing the updated information.
   * 
   * @return The updated User entity.
   */

  public User update(Long id, User obj) {
    User entity = repository.getReferenceById(id);
    updateData(entity, obj);
    return repository.save(entity);
  }

  private void updateData(User entity, User obj) {
    entity.setName(obj.getName());
    entity.setEmail(obj.getEmail());
    entity.setPhone(obj.getPhone());
  }

}
