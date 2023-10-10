package com.victordev.course.services;

import com.victordev.course.entities.User;
import com.victordev.course.repositories.UserRepository;
import com.victordev.course.services.exceptions.DatabaseException;
import com.victordev.course.services.exceptions.ResourceNotFoundException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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
    return obj.orElseThrow(() -> new ResourceNotFoundException(id));
  }

  public User insert(User obj) {
    return repository.save(obj);
  }

  /**
   * Delete a user by its ID.
   *
   * @param id The ID of the user to be deleted.
   * @throws ResourceNotFoundException If the user with the specified ID is not found in the
   *         repository.
   */

  public void delete(Long id) {
    try {
      repository.deleteById(id);
    } catch (EmptyResultDataAccessException e) {
      throw new ResourceNotFoundException(id);
    } catch (DataIntegrityViolationException e) {
      throw new DatabaseException(e.getMessage());
    }
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
