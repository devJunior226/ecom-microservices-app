package dev.juldas.ecommerce.record;

import dev.juldas.ecommerce.entity.Address;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

/**
 * Author: Juldas RAMDE
 * Since: 20/10/2024 at 12:59
 */
public record CustomerRequest(
        String id,

        @NotNull(message = "Customer firstname is required")
        String firstName,

        @NotNull(message = "Customer lastname is required")
        String lastName,

        @NotNull(message = "Customer email is required")
        @Email(message = "Customer email is invalid")
        String email,

        Address address
)
{ }
