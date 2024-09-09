package com.elbuensabor.apirest.Service;

import com.elbuensabor.apirest.Entity.UnitOfMeasure;
import com.elbuensabor.apirest.Exception.MiException;

import java.util.List;

public interface UnitOfMeasureService {
    List<UnitOfMeasure> getAllUnitsOfMeasure();
    UnitOfMeasure getUnitOfMeasureById(Long id) throws MiException;
    UnitOfMeasure createUnitOfMeasure(UnitOfMeasure unitOfMeasure) throws MiException;
    UnitOfMeasure updateUnitOfMeasure(Long id, UnitOfMeasure unitOfMeasure) throws MiException;
    void deleteUnitOfMeasure(Long id) throws MiException;
}
