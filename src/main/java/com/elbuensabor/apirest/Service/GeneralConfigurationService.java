package com.elbuensabor.apirest.Service;

import com.elbuensabor.apirest.Entity.GeneralConfiguration;
import com.elbuensabor.apirest.Exception.MiException;

import java.util.List;

public interface GeneralConfigurationService {
    List<GeneralConfiguration> getAllConfigurations();
    GeneralConfiguration getConfigurationById(Long id) throws MiException;
    GeneralConfiguration createConfiguration(GeneralConfiguration configuration) throws MiException;
    GeneralConfiguration updateConfiguration(Long id, GeneralConfiguration configuration) throws MiException;
    void deleteConfiguration(Long id) throws MiException;
}
