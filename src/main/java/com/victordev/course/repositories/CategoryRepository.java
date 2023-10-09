package com.victordev.course.repositories;

import com.victordev.course.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Provides access to the database for Category entities.
 */

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
