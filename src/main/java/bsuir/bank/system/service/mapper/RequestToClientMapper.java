package bsuir.bank.system.service.mapper;

import org.springframework.stereotype.Component;

import bsuir.bank.system.api.model.NewClientRequest;
import bsuir.bank.system.dao.model.Client;
import bsuir.bank.system.dao.model.ClientPassport;
import bsuir.bank.system.service.MetadataService;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class RequestToClientMapper {

    private final MetadataService metadataService;

    public Client toClient(NewClientRequest newClientRequest) {
        return Client.builder()
                .id(newClientRequest.getId())
                .firstName(newClientRequest.getFirstName())
                .lastName(newClientRequest.getLastName())
                .middleName(newClientRequest.getMiddleName())
                .birthDate(newClientRequest.getBirthDate())
                .gender(newClientRequest.getGender())
                .passport(buildPassport(newClientRequest))
                .mobilePhone(newClientRequest.getMobilePhone())
                .homeNumber(newClientRequest.getHomeNumber())
                .email(newClientRequest.getEmail())
                .maritalStatus(metadataService.findMaritalStatusById(newClientRequest.getMaritalStatusId()))
                .disability(
                        newClientRequest.getDisabilityId() == null ? null : metadataService.findDisabilityById(newClientRequest.getDisabilityId()))
                .monthlySalary(newClientRequest.getMonthlySalary())
                .isPensioner(newClientRequest.getIsPensioner())
                .factAddress(newClientRequest.getFactAddress())
                .factCity(metadataService.findCityById(newClientRequest.getFactCityId()))
                .citizenship(metadataService.findCitizenshipById(newClientRequest.getCitizenshipId()))
                .build();
    }

    private ClientPassport buildPassport(NewClientRequest newClientRequest) {
        return ClientPassport.builder()
                .id(newClientRequest.getPspId())
                .series(newClientRequest.getPspSeries())
                .number(newClientRequest.getPspNumber())
                .issuedDate(newClientRequest.getPspIssuedDate())
                .issuedBy(newClientRequest.getPspIssuedBy())
                .idNumber(newClientRequest.getPspIdNumber())
                .birthPlace(newClientRequest.getBirthPlace())
                .registrationCity(metadataService.findCityById(newClientRequest.getRegistrationCityId()))
                .build();
    }

    public NewClientRequest toNewClientRequest(Client client) {
        return NewClientRequest.builder()
                .id(client.getId())
                .pspId(client.getPassport().getId())
                .firstName(client.getFirstName())
                .lastName(client.getLastName())
                .middleName(client.getMiddleName())
                .birthDate(client.getBirthDate())
                .gender(client.getGender())
                .pspSeries(client.getPassport().getSeries())
                .pspNumber(client.getPassport().getNumber())
                .pspIdNumber(client.getPassport().getIdNumber())
                .pspIssuedDate(client.getPassport().getIssuedDate())
                .pspIssuedBy(client.getPassport().getIssuedBy())
                .birthPlace(client.getPassport().getBirthPlace())
                .registrationCityId(client.getPassport().getRegistrationCity().getId())
                .mobilePhone(client.getMobilePhone())
                .homeNumber(client.getHomeNumber())
                .email(client.getEmail())
                .maritalStatusId(client.getMaritalStatus().getId())
                .disabilityId((client.getDisability()==null)? null :client.getDisability().getId())
                .monthlySalary(client.getMonthlySalary())
                .isPensioner(client.getIsPensioner())
                .factCityId(client.getFactCity().getId())
                .factAddress(client.getFactAddress())
                .citizenshipId(client.getCitizenship().getId())
                .build();
    }
}
