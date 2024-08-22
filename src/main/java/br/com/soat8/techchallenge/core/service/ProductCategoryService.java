package br.com.soat8.techchallenge.core.service;

import br.com.soat8.techchallenge.core.port.in.ProductCategoryUseCase;
import br.com.soat8.techchallenge.core.port.out.ProductCategoryPort;
import br.com.soat8.techchallenge.domain.ProductCategory;
import br.com.soat8.techchallenge.domain.exception.ProductCategoryNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;

@Service
public class ProductCategoryService implements ProductCategoryUseCase {

    private final ProductCategoryPort productCategoryPort;

    public ProductCategoryService(ProductCategoryPort productCategoryPort) {
        this.productCategoryPort = productCategoryPort;
    }

    @Override
    public ProductCategory findProductCategory(UUID productCategoryId) {
        ProductCategory productCategory = productCategoryPort.findProductCategory(productCategoryId);
        categoryNotFound(productCategory);
        return productCategory;
    }

    private void categoryNotFound(ProductCategory productCategory) {
        if(Objects.isNull(productCategory)){
            throw new ProductCategoryNotFoundException("Product Category not found");
        }
    }

}