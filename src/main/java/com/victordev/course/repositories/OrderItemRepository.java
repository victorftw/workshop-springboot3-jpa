package com.victordev.course.repositories;

import com.victordev.course.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Provides access to the database for OrderItem entities.
 */

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
