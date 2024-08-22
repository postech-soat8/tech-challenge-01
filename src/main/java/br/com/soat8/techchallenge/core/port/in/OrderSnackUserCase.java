package br.com.soat8.techchallenge.core.port.in;

import br.com.soat8.techchallenge.adapter.out.persistence.entity.enums.OrderProgress;
import br.com.soat8.techchallenge.domain.OrderSnack;

import java.util.List;

public interface OrderSnackUserCase {
    List<OrderSnack> listOrderSnack(OrderProgress progress, String cpf);
}
