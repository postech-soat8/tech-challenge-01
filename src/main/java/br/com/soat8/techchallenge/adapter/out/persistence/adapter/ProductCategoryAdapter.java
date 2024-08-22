package br.com.soat8.techchallenge.adapter.out.persistence.adapter;

import br.com.soat8.techchallenge.adapter.out.persistence.entity.ProductCategoryEntity;
import br.com.soat8.techchallenge.adapter.out.persistence.entity.ProductEntity;
import br.com.soat8.techchallenge.adapter.out.persistence.retository.ProductCategoryRepository;
import br.com.soat8.techchallenge.core.port.out.ProductCategoryPort;
import br.com.soat8.techchallenge.domain.Product;
import br.com.soat8.techchallenge.domain.ProductCategory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class ProductCategoryAdapter implements ProductCategoryPort {

    private final ProductCategoryRepository productCategoryRepository;

    public ProductCategoryAdapter(ProductCategoryRepository productCategoryRepository) {
        this.productCategoryRepository = productCategoryRepository;
    }

    @Override
    public ProductCategory findProductCategory(UUID productCategoryId) {
        return productCategoryRepository.findById(productCategoryId).map(this::build).orElse(null);
    }

    private ProductCategory build(ProductCategoryEntity entity) {
        if (entity == null) {
            return null;
        }
        return ProductCategory.builder()
                .productCategoryId(entity.getProductCategoryId())
                .description(entity.getDescription())
                .products(buildProductList(entity.getProducts()))
                .build();
    }

    private List<Product> buildProductList(List<ProductEntity> products) {
        return products.stream().map(this::buildProduct).collect(Collectors.toList());
    }

    private Product buildProduct(ProductEntity entity) {
        if (entity == null) {
            return null;
        }
        return Product.builder()
                .productId(entity.getProductId())
                .name(entity.getName())
                .description(entity.getDescription())
                .price(entity.getPrice())
                .build();
    }

}
