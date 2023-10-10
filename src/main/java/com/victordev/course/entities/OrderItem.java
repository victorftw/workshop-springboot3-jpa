package com.victordev.course.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.victordev.course.entities.pk.OrderItemPk;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

/**
 * Represents an item in an order.
 */

@Entity
@Table(name = "tb_order_item")
public class OrderItem implements Serializable {

  private static final long serialVersionUID = 1L;

  @EmbeddedId
  private OrderItemPk id = new OrderItemPk();

  private Integer quantity;
  private Double price;

  public OrderItem() {

  }

  /**
   * Constructs an order item with the specified order, product, quantity, and price.
   *
   * @param order The order to which this item belongs.
   * @param product The product in this order item.
   * @param quantity The quantity of the product in this order item.
   * @param price The price of the product in this order item.
   */

  public OrderItem(Order order, Product product, Integer quantity, Double price) {
    id.setOrder(order);
    id.setProduct(product);
    this.quantity = quantity;
    this.price = price;
  }

  @JsonIgnore
  public Order getOrder() {
    return id.getOrder();
  }

  public void setOrder(Order order) {
    id.setOrder(order);
  }

  public Product getProduct() {
    return id.getProduct();
  }

  public void setProduct(Product product) {
    id.setProduct(product);
  }

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public Double getSubTotal() {
    return price * quantity;
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
    OrderItem other = (OrderItem) obj;
    return Objects.equals(id, other.id);
  }
}
