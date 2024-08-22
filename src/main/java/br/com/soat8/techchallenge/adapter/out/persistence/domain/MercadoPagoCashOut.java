package br.com.soat8.techchallenge.adapter.out.persistence.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class MercadoPagoCashOut {
    private BigDecimal amount;
}
