package com.elbuensabor.apirest.Service;

import com.elbuensabor.apirest.Entity.UnitOfMeasure;
import com.elbuensabor.apirest.Exception.MiException;
import com.elbuensabor.apirest.Repository.UnitOfMeasureRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnitOfMeasureServiceImpl implements UnitOfMeasureService {

    @Autowired
    private UnitOfMeasureRepository unitOfMeasureRepository;

    @Override
    public List<UnitOfMeasure> getAllUnitsOfMeasure() {
        return unitOfMeasureRepository.findAll();
    }

    @Override
    public UnitOfMeasure getUnitOfMeasureById(Long id) throws MiException {
        return unitOfMeasureRepository.findById(id)
                .orElseThrow(() -> new MiException("UnitOfMeasure not found with id: " + id));
    }

    @Override
    @Transactional
    public UnitOfMeasure createUnitOfMeasure(UnitOfMeasure unitOfMeasure) throws MiException {
        try {
            return unitOfMeasureRepository.save(unitOfMeasure);
        } catch (Exception e) {
            throw new MiException("Error creating UnitOfMeasure!", e);
        }
    }

    @Override
    @Transactional
    public UnitOfMeasure updateUnitOfMeasure(Long id, UnitOfMeasure unitOfMeasure) throws MiException {
        UnitOfMeasure existingUnitOfMeasure = unitOfMeasureRepository.findById(id)
                .orElseThrow(() -> new MiException("UnitOfMeasure not found with id: " + id));

        existingUnitOfMeasure.setName(unitOfMeasure.getName());
        existingUnitOfMeasure.setProducts(unitOfMeasure.getProducts());

        try {
            return unitOfMeasureRepository.save(existingUnitOfMeasure);
        } catch (Exception e) {
            throw new MiException("Error updating UnitOfMeasure!", e);
        }
    }

    @Override
    @Transactional
    public void deleteUnitOfMeasure(Long id) throws MiException {
        UnitOfMeasure existingUnitOfMeasure = unitOfMeasureRepository.findById(id)
                .orElseThrow(() -> new MiException("UnitOfMeasure not found with id: " + id));

        try {
            unitOfMeasureRepository.delete(existingUnitOfMeasure);
        } catch (Exception e) {
            throw new MiException("Error deleting UnitOfMeasure!", e);
        }
    }
}
