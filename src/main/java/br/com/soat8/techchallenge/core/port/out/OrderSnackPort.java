package br.com.soat8.techchallenge.core.port.out;

import br.com.soat8.techchallenge.adapter.out.persistence.entity.enums.OrderProgress;
import br.com.soat8.techchallenge.domain.OrderSnack;

import java.util.List;

public interface OrderSnackPort {

    List<OrderSnack> listOrderSnack(OrderProgress progress, String cpf);

    void saveOrderSnack(OrderSnack orderSnack);
}
