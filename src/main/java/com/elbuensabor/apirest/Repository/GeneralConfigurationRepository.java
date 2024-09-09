package com.elbuensabor.apirest.Repository;

import com.elbuensabor.apirest.Entity.GeneralConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneralConfigurationRepository extends JpaRepository<GeneralConfiguration, Long> {
}
