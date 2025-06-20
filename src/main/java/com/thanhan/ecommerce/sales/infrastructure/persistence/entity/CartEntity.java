package com.thanhan.ecommerce.sales.infrastructure.persistence.entity;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "carts")
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CartEntity {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "user_id", nullable = false)
    private String userId;
    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<CartItemEntity> items;

    @Column(name = "created_at")
    private Instant createdAt;

}
