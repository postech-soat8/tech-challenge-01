package br.com.soat8.techchallenge.domain;

import br.com.soat8.techchallenge.domain.group.OnUpdate;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.NotNull;
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
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Product {

    @NotNull(groups = OnUpdate.class, message = "CategoryId is required for update")
    private UUID productId;

    private UUID categoryId;

    @NotNull(message = "name product required")
    private String name;

    private BigDecimal price;

    private String description;


}