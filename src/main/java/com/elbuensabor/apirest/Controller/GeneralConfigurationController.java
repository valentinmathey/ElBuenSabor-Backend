package com.elbuensabor.apirest.Controller;

import com.elbuensabor.apirest.Entity.GeneralConfiguration;
import com.elbuensabor.apirest.Service.GeneralConfigurationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/configurations")
public class GeneralConfigurationController {

    @Autowired
    private GeneralConfigurationServiceImpl generalConfigurationServiceImpl;

    @GetMapping
    public List<GeneralConfiguration> getAllConfigurations() {
        return generalConfigurationServiceImpl.getAllConfigurations();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GeneralConfiguration> getConfigurationById(@PathVariable Long id) {
        GeneralConfiguration config = generalConfigurationServiceImpl.getConfigurationById(id);
        return ResponseEntity.ok(config);
    }

    @PostMapping
    public ResponseEntity<GeneralConfiguration> createConfiguration(@RequestBody GeneralConfiguration config) {
        GeneralConfiguration newConfig = generalConfigurationServiceImpl.createConfiguration(config);
        return ResponseEntity.status(HttpStatus.CREATED).body(newConfig);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GeneralConfiguration> updateConfiguration(@PathVariable Long id, @RequestBody GeneralConfiguration config) {
        GeneralConfiguration updatedConfig = generalConfigurationServiceImpl.updateConfiguration(id, config);
        return ResponseEntity.ok(updatedConfig);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConfiguration(@PathVariable Long id) {
        generalConfigurationServiceImpl.deleteConfiguration(id);
        return ResponseEntity.noContent().build();
    }
}

