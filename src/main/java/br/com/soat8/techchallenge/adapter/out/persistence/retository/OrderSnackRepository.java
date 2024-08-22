package br.com.soat8.techchallenge.adapter.out.persistence.retository;

import br.com.soat8.techchallenge.adapter.out.persistence.entity.OrderSnackEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrderSnackRepository extends JpaRepository<OrderSnackEntity, UUID>, JpaSpecificationExecutor<OrderSnackEntity> {
}
