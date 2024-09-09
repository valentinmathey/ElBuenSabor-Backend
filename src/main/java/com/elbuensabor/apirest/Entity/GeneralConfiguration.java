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
@Table(name = "GENERAL_CONFIGURATION")
@Entity
@Audited
public class GeneralConfiguration {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "number_of_cooks")
    private Integer numberOfCooks;

    @Column(name = "company_email")
    private String companyEmail;

    @Column(name = "mercado_pago_token")
    private String mercadoPagoToken;
}

