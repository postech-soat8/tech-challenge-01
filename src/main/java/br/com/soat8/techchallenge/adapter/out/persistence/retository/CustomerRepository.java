package br.com.soat8.techchallenge.adapter.out.persistence.retository;

import br.com.soat8.techchallenge.adapter.out.persistence.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, UUID> {
    Optional<CustomerEntity> findByCpf(String cpf);

    Optional<CustomerEntity> findByEmailAddress(String emailAddress);

}