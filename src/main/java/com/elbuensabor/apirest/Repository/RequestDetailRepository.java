package com.elbuensabor.apirest.Repository;

import com.elbuensabor.apirest.Entity.RequestDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestDetailRepository extends JpaRepository<RequestDetail, Long> {
}
