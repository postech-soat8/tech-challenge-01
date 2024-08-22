package br.com.soat8.techchallenge.adapter.out.persistence.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MercadoPagoOrder {
    private String description;
    @JsonProperty("external_reference")
    private String externalReference;
    private List<MercadoPagoItem> items;
    private String title;
    @JsonProperty("total_amount")
    private BigDecimal totalAmount;
}
