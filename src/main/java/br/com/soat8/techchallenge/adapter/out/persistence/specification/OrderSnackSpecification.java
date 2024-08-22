package br.com.soat8.techchallenge.adapter.out.persistence.specification;

import br.com.soat8.techchallenge.adapter.out.persistence.entity.OrderSnackEntity;
import br.com.soat8.techchallenge.adapter.out.persistence.entity.enums.OrderProgress;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDateTime;

public class OrderSnackSpecification {

    public static Specification<OrderSnackEntity> hasProgress(OrderProgress progress) {
        return (root, query, criteriaBuilder) -> {
            if (progress == null) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.equal(root.get("progress"), progress);
        };
    }

    public static Specification<OrderSnackEntity> hasCreatedAt(LocalDateTime createdAt) {
        return (root, query, criteriaBuilder) -> {
            if (createdAt == null) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.equal(root.get("createdAt"), createdAt);
        };
    }

    public static Specification<OrderSnackEntity> hasCustomerCpf(String cpf) {
        return (root, query, criteriaBuilder) -> {
            if (cpf == null) {
                return criteriaBuilder.conjunction();
            }
            return criteriaBuilder.equal(root.get("customer").get("cpf"), cpf);
        };
    }
}
