package bsuir.bank.system.service;

import java.util.List;

import org.springframework.stereotype.Service;

import bsuir.bank.system.dao.CitizenshipRepository;
import bsuir.bank.system.dao.CityRepository;
import bsuir.bank.system.dao.DisabilityRepository;
import bsuir.bank.system.dao.MaritalStatusRepository;
import bsuir.bank.system.dao.model.Citizenship;
import bsuir.bank.system.dao.model.City;
import bsuir.bank.system.dao.model.ClientDisability;
import bsuir.bank.system.dao.model.MaritalStatus;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MetadataService {
    private final CityRepository cityRepository;
    private final CitizenshipRepository citizenshipRepository;
    private final MaritalStatusRepository maritalStatusRepository;
    private final DisabilityRepository disabilityRepository;

    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    public List<Citizenship> getAllCitizenship() {
        return citizenshipRepository.findAll();
    }

    public List<MaritalStatus> getAllMaritalStatuses() {
        return maritalStatusRepository.findAll();
    }

    public List<ClientDisability> getAllDisabilityTypes() {
        return disabilityRepository.findAll();
    }
}
