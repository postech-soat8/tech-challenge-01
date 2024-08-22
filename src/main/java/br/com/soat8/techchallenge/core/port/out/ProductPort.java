package br.com.soat8.techchallenge.core.port.out;

import br.com.soat8.techchallenge.domain.Product;
import br.com.soat8.techchallenge.domain.ProductCategory;

import java.util.UUID;

public interface ProductPort {

    void saveProduct(Product product, ProductCategory productCategory);
    void removeProduct(UUID productId);
    Boolean findById(UUID productId);

}