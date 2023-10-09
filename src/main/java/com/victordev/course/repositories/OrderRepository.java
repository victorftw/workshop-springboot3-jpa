package com.victordev.course.repositories;

import com.victordev.course.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Provides access to the database for Order entities.
 */

public interface OrderRepository extends JpaRepository<Order, Long> {

}
