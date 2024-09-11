package com.elbuensabor.apirest.Entity;

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
@Table(name = "UNIT_OF_MESURE")
@Entity
@Audited
public class UnitOfMeasure {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

        @Column(name = "name")
        private String name;

        @OneToMany(mappedBy = "unitOfMeasure")
        @Builder.Default
        private List<Product> products = new ArrayList<>();
}
