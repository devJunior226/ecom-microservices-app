package dev.juldas.ecommerce.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Author: Juldas RAMDE
 * Since: 20/10/2024 at 13:45
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class CustomerNotFoundException extends RuntimeException {
    private final String message;
}
