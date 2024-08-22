package br.com.soat8.techchallenge.adapter.out.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;

import java.io.Serial;
import java.io.Serializable;
import java.sql.Types;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "customer")
public class CustomerEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = -625217961631509597L;

    @Id
    @GeneratedValue(generator = "UUID2")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "customer_id")
    @JdbcTypeCode(Types.VARCHAR)
    private UUID customerId;

    private String name;

    private String emailAddress;

    private String cpf;
}
