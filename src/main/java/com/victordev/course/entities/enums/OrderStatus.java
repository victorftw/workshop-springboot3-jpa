package com.victordev.course.entities.enums;

/**
 * Enum representing the possible status of an order.
 */

public enum OrderStatus {
  WAITING_PAYMENT(1), PAID(2), SHIPPED(3), DELIVERED(4), CANCELED(5);

  private int code;

  private OrderStatus(int code) {
    this.code = code;
  }

  public int getCode() {
    return code;
  }

  /**
   * Converts an integer code into an OrderStatus enum value.
   *
   * @param code The code to convert.
   * @return The corresponding OrderStatus enum value.
   * @throws IllegalArgumentException If the provided code is invalid.
   */

  public static OrderStatus valueOf(int code) {
    for (OrderStatus value : OrderStatus.values()) {
      if (value.getCode() == code) {
        return value;
      }
    }
    throw new IllegalArgumentException("Invalid OrderStatus code");
  }

}
