package com.thanhan.ecommerce.sales.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "categories")
@Setter
@Getter
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name="uri", unique=true, nullable=false)
    private String uri;

    @ManyToMany(mappedBy = "categories", fetch = FetchType.LAZY)
    private Set<ProductEntity> products = new HashSet<>();
}
