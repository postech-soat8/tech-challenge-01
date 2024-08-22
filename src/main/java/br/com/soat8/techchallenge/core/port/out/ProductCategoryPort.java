package br.com.soat8.techchallenge.core.port.out;

import br.com.soat8.techchallenge.domain.ProductCategory;

import java.util.UUID;

public interface ProductCategoryPort {

    ProductCategory findProductCategory(UUID productCategoryId);

}