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
import java.math.BigDecimal;
import java.sql.Types;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "order_snack_item")
public class OrderSnackItemEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = -1984785471203763088L;

    @Id
    @GeneratedValue(generator = "UUID2")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "order_snack_item_id")
    @JdbcTypeCode(Types.VARCHAR)
    private UUID orderSnackItemId;

    @ManyToOne
    @JoinColumn(name = "order_snack_id", nullable = false)
    private OrderSnackEntity orderSnack;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private ProductEntity product;

    @Column(name = "amount", precision = 10, scale = 2, nullable = false)
    private BigDecimal amount;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;
}
