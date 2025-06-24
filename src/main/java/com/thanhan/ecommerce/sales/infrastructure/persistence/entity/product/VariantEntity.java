package com.thanhan.ecommerce.sales.infrastructure.persistence.entity.product;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Table(name = "variants")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VariantEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @OneToMany(mappedBy = "variant", orphanRemoval = true, cascade = CascadeType.ALL)
    private Set<VariantValueEntity> values;
}
