package br.com.soat8.techchallenge.core.port.in;

import br.com.soat8.techchallenge.domain.Product;

import java.util.UUID;

public interface ProductUseCase {

    void saveProduct(Product product);
    void removeProduct(UUID productId);

}