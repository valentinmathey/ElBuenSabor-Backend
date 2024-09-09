package com.elbuensabor.apirest.Service;

import com.elbuensabor.apirest.Entity.GeneralConfiguration;
import com.elbuensabor.apirest.Exception.MiException;
import com.elbuensabor.apirest.Repository.GeneralConfigurationRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeneralConfigurationServiceImpl implements GeneralConfigurationService {

    @Autowired
    private GeneralConfigurationRepository generalConfigurationRepository;

    @Override
    public List<GeneralConfiguration> getAllConfigurations() {
        return generalConfigurationRepository.findAll();
    }

    @Override
    public GeneralConfiguration getConfigurationById(Long id) throws MiException {
        return generalConfigurationRepository.findById(id)
                .orElseThrow(() -> new MiException("Configuration not found with id: " + id));
    }

    @Override
    @Transactional
    public GeneralConfiguration createConfiguration(GeneralConfiguration configuration) throws MiException {
        try {
            return generalConfigurationRepository.save(configuration);
        } catch (Exception e) {
            throw new MiException("Error creating configuration!");
        }
    }

    @Override
    @Transactional
    public GeneralConfiguration updateConfiguration(Long id, GeneralConfiguration configuration) throws MiException {
        GeneralConfiguration existingConfiguration = generalConfigurationRepository.findById(id)
                .orElseThrow(() -> new MiException("Configuration not found with id: " + id));

        existingConfiguration.setNumberOfCooks(configuration.getNumberOfCooks());
        existingConfiguration.setCompanyEmail(configuration.getCompanyEmail());
        existingConfiguration.setMercadoPagoToken(configuration.getMercadoPagoToken());

        try {
            return generalConfigurationRepository.save(existingConfiguration);
        } catch (Exception e) {
            throw new MiException("Error updating configuration!");
        }
    }

    @Override
    @Transactional
    public void deleteConfiguration(Long id) throws MiException {
        GeneralConfiguration existingConfiguration = generalConfigurationRepository.findById(id)
                .orElseThrow(() -> new MiException("Configuration not found with id: " + id));

        try {
            generalConfigurationRepository.delete(existingConfiguration);
        } catch (Exception e) {
            throw new MiException("Error deleting configuration!");
        }
    }
}
