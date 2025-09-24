package com.ecommerce.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class ProductResponseDto {

        private Long id;
        private String name;
        private String description;
        private BigDecimal price;
        private Integer stock;
        private LocalDateTime createdAt;

}


