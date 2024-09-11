package com.elbuensabor.apirest.Entity;

import com.elbuensabor.apirest.Enums.DeliveryType;
import com.elbuensabor.apirest.Enums.SalesOrderStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "SALES_ORDER")
@Entity
@Audited
public class SalesOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "date")
    private String date;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private SalesOrderStatus status;

    @Column(name = "estimated_delivery_time")
    private Date estimatedDeliveryTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "delivery_type")
    private DeliveryType deliveryType;

    @Column(name = "total")
    private Double total;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToOne
    @JoinColumn(name = "invoice_id")
    private Invoice invoice;

    @OneToMany(mappedBy = "salesOrder", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<SalesOrderDetail> salesOrderDetails = new ArrayList<>();
}

