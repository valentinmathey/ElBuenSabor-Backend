package com.elbuensabor.apirest.Entity;

import com.elbuensabor.apirest.Enums.ProductType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "PRODUCT")
@Entity
@Audited
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private ProductType type;

    @Column(name = "estimated_cooking_time")
    private Integer estimatedCookingTime;

    @Column(name = "name")
    private String name;

    @Column(name = "purchase_price")
    private Double purchasePrice;

    @Column(name = "sale_price")
    private Double salePrice;

    @Column(name = "current_stock")
    private Integer currentStock;

    @Column(name = "minimum_stock")
    private Integer minimumStock;

    @Column(name = "photo")
    private String photo;

    @Column(name = "recipe", length = 1500)
    private String recipe;

    @ManyToOne
    @JoinColumn(name = "unit_of_measure_id")
    private UnitOfMeasure unitOfMeasure;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<RequestDetail> requestDetails = new ArrayList<>();
}

