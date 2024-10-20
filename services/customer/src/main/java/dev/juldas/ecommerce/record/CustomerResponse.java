package dev.juldas.ecommerce.record;

import dev.juldas.ecommerce.entity.Address;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

/**
 * Author: Juldas RAMDE
 * Since: 20/10/2024 at 14:01
 */
public record CustomerResponse(
        String id,
        String firstName,
        String lastName,
        String email,
        Address address
) { }
