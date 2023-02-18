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
import bsuir.bank.system.service.exception.EntityNotFound;
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

    public MaritalStatus findMaritalStatusById(Long maritalStatusId) {
        return maritalStatusRepository.findById(maritalStatusId)
                .orElseThrow(() -> new EntityNotFound(String.format("Marital Status with Id %s is not found.", maritalStatusId)));
    }

    public ClientDisability findDisabilityById(Long disabilityId) {
        return disabilityRepository.findById(disabilityId)
                .orElseThrow(() -> new EntityNotFound(String.format("Disability type with Id %s is not found.", disabilityId)));
    }

    public City findCityById(Long cityId) {
        return cityRepository.findById(cityId)
                .orElseThrow(() -> new EntityNotFound(String.format("City with Id %s is not found.", cityId)));
    }

    public Citizenship findCitizenshipById(Long citizenshipId) {
        return citizenshipRepository.findById(citizenshipId)
                .orElseThrow(() -> new EntityNotFound(String.format("citizenship with Id %s is not found.", citizenshipId)));
    }
}
