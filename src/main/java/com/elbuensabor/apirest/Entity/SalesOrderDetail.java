package com.elbuensabor.apirest.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "SALES_ORDER_DETAIL")
@Entity
@Audited
public class SalesOrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "subtotal")
    private Double subtotal;

    @ManyToOne
    @JoinColumn(name = "sales_order_id")
    private SalesOrder salesOrder;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}

