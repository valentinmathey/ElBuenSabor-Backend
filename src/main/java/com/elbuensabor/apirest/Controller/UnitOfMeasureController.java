package com.elbuensabor.apirest.Controller;

import com.elbuensabor.apirest.Entity.UnitOfMeasure;
import com.elbuensabor.apirest.Service.UnitOfMeasureServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/units")
public class UnitOfMeasureController {

    @Autowired
    private UnitOfMeasureServiceImpl unitOfMeasureServiceImpl;

    @GetMapping
    public List<UnitOfMeasure> getAllUnits() {
        return unitOfMeasureServiceImpl.getAllUnitsOfMeasure();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UnitOfMeasure> getUnitById(@PathVariable Long id) {
        UnitOfMeasure unit = unitOfMeasureServiceImpl.getUnitOfMeasureById(id);
        return ResponseEntity.ok(unit);
    }

    @PostMapping
    public ResponseEntity<UnitOfMeasure> createUnit(@RequestBody UnitOfMeasure unit) {
        UnitOfMeasure newUnit = unitOfMeasureServiceImpl.createUnitOfMeasure(unit);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUnit);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UnitOfMeasure> updateUnit(@PathVariable Long id, @RequestBody UnitOfMeasure unit) {
        UnitOfMeasure updatedUnit = unitOfMeasureServiceImpl.updateUnitOfMeasure(id, unit);
        return ResponseEntity.ok(updatedUnit);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUnit(@PathVariable Long id) {
        unitOfMeasureServiceImpl.deleteUnitOfMeasure(id);
        return ResponseEntity.noContent().build();
    }
}

