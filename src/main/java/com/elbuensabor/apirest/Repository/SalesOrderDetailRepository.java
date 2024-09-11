package com.elbuensabor.apirest.Repository;

import com.elbuensabor.apirest.Entity.SalesOrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesOrderDetailRepository extends JpaRepository<SalesOrderDetail, Long> {
}
