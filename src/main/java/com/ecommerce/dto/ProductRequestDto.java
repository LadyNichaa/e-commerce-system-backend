package com.ecommerce.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
public class ProductRequestDto {
    @NotBlank(message = "Product name cannot be blank")
    private String name;

    @Size(max = 500)
    private String description;

    @NotNull(message = "Price is required")
    @Positive(message = "Price must be a positive value")
    private BigDecimal price;

    @NotNull(message = "Stock quantity is required")
    @Positive(message = "Price must be a positive value")
    private Integer stock;
}
