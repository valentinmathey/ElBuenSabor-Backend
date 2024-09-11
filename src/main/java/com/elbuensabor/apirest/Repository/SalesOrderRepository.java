package com.elbuensabor.apirest.Repository;

import com.elbuensabor.apirest.Entity.SalesOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesOrderRepository extends JpaRepository<SalesOrder, Long> {
}
