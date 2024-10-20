package dev.juldas.ecommerce.handler;

import java.util.Map;

/**
 * Author: Juldas RAMDE
 * Since: 20/10/2024 at 14:42
 */
public record ErrorResponse(
        Map<String, String> errors
) {
}
