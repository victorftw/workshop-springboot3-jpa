package com.victordev.course.repositories;

import com.victordev.course.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Provides access to the database for Product entities.
 */

public interface ProductRepository extends JpaRepository<Product, Long> {

}
