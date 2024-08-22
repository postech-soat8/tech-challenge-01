package br.com.soat8.techchallenge.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderSnackItem {
    private UUID orderSnackItemId;
    private BigDecimal amount;
    private String productName;

    @JsonProperty("product_id")
    @NotBlank
    private UUID productId;
    @NotBlank
    private BigDecimal price;

    @Min(value = 1, message = "The quantity must be more than zero.")
    private Integer quantity;
}
