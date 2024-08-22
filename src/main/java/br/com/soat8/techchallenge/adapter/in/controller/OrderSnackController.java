package br.com.soat8.techchallenge.adapter.in.controller;

import br.com.soat8.techchallenge.adapter.out.persistence.entity.enums.OrderProgress;
import br.com.soat8.techchallenge.core.port.in.OrderSnackUseCase;
import br.com.soat8.techchallenge.domain.OrderSnack;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(OrderSnackController.BASE_URL)
public class OrderSnackController {
    public static final String BASE_URL = "/lanchonete/order";

    private final OrderSnackUseCase orderSnackUseCase;

    public OrderSnackController(OrderSnackUseCase orderSnackUseCase) {
        this.orderSnackUseCase = orderSnackUseCase;
    }

    @GetMapping
    public ResponseEntity<List<OrderSnack>> cadastrarCliente( @RequestParam(required = false) OrderProgress progress,
                                                              @RequestParam(required = false) String cpf) {
        List<OrderSnack> orderSnacks = orderSnackUseCase.listOrderSnack(progress, cpf);
        return ResponseEntity.ok(orderSnacks);
    }


}
