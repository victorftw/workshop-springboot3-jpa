package com.victordev.course.repositories;

import com.victordev.course.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Provides data access methods for the User entity.
 * <p>
 * This interface extends JpaRepository to inherit basic CRUD operations for User entities.
 * </p>
 */

public interface UserRepository extends JpaRepository<User, Long> {

}
