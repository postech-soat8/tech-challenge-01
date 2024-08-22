package br.com.soat8.techchallenge.adapter.out.persistence.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class MercadoPagoItem {
    public String title;
    @JsonProperty("unit_price")
    public BigDecimal unitPrice;
    public int quantity;
    @JsonProperty("unit_measure")
    public String unitMeasure;
    @JsonProperty("total_amount")
    public BigDecimal totalAmount;

    public MercadoPagoItem(String title, BigDecimal unitPrice, int quantity, String unitMeasure, BigDecimal amount) {
        this.title = title;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.unitMeasure = unitMeasure;
        this.totalAmount = amount;
    }
}
