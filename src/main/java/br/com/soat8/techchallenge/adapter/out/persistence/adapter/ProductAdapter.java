package br.com.soat8.techchallenge.adapter.out.persistence.adapter;

import br.com.soat8.techchallenge.adapter.out.persistence.entity.ProductCategoryEntity;
import br.com.soat8.techchallenge.adapter.out.persistence.entity.ProductEntity;
import br.com.soat8.techchallenge.adapter.out.persistence.retository.ProductRepository;
import br.com.soat8.techchallenge.core.port.out.ProductPort;
import br.com.soat8.techchallenge.domain.Product;
import br.com.soat8.techchallenge.domain.ProductCategory;
import br.com.soat8.techchallenge.domain.exception.NotFoundProductException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Component
public class ProductAdapter implements ProductPort {

    private final ProductRepository productRepository;

    public ProductAdapter(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void saveProduct(Product product, ProductCategory productCategory) {
        saveOrUpdate(product, productCategory);
    }

    @Transactional
    @Override
    public void removeProduct(UUID productId) {
        productRepository.findById(productId)
                .ifPresentOrElse(
                        product -> {
                            // Remove todas as dependências antes de excluir o produto
                            product.getOrderItems().clear();
                            productRepository.delete(product);
                        },
                        () -> {
                            throw new NotFoundProductException("Product not found with ID: " + productId);
                        }
                );
    }

    @Override
    public Boolean findById(UUID id) {
        return productRepository.findById(id).isPresent();
    }

    private void saveOrUpdate(Product product, ProductCategory productCategory) {
        ProductEntity productEntity = new ProductEntity();
        ProductCategoryEntity productCategoryEntity = new ProductCategoryEntity();

        productCategoryEntity.setProductCategoryId(productCategory.getProductCategoryId());
        productEntity.setName(product.getName());
        productEntity.setPrice(product.getPrice());
        productEntity.setCategory(productCategoryEntity);
        productEntity.setDescription(product.getDescription());

        if (product.getProductId() != null) {
            productEntity.setProductId(product.getProductId());
        }

        productRepository.save(productEntity);
    }

}
