package bsuir.bank.system.service;

import java.util.List;

import org.springframework.stereotype.Service;

import bsuir.bank.system.api.model.NewClientRequest;
import bsuir.bank.system.dao.ClientRepository;
import bsuir.bank.system.dao.PassportRepository;
import bsuir.bank.system.dao.model.Client;
import bsuir.bank.system.dao.model.ClientPassport;
import bsuir.bank.system.service.exception.EntityNotFound;
import bsuir.bank.system.service.exception.InvalidPassportData;
import bsuir.bank.system.service.mapper.RequestToClientMapper;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;
    private final PassportRepository passportRepository;

    private final RequestToClientMapper mapper;

    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    @Transactional
    public Client create(NewClientRequest newClientRequest) {
        Client client = mapper.toClient(newClientRequest);
        if (passportRepository.existsByIdNumberIgnoreCase(client.getPassport().getIdNumber())) {
            throw new InvalidPassportData(
                    String.format("Паспорт с идентификационным номером %s уже зарегистрирован", client.getPassport().getIdNumber()));
        }
        ClientPassport clientPassport = passportRepository.save(client.getPassport());
        client.setPassport(clientPassport);
        return clientRepository.save(client);
    }

    public Client get(Long id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new EntityNotFound(String.format("Client with id %s is not found", id)));
    }

    public Client update(@Valid NewClientRequest newClient, Long id) {
        Client curClient = clientRepository.findById(id).orElseThrow(() -> new EntityNotFound(String.format("Client with id %s is not found", id)));
        if (passportRepository.existsByIdNumberIgnoreCase(newClient.getPspIdNumber())
                && !curClient.getPassport().getIdNumber().equals(newClient.getPspIdNumber())) {
            throw new InvalidPassportData(
                    String.format("Паспорт с идентификационным номером %s уже зарегистрирован", newClient.getPspIdNumber()));
        }

        Client updatedclient = mapper.toClient(newClient);
        updatedclient.getPassport().setId(curClient.getPassport().getId());
        return clientRepository.save(updatedclient);
    }

    public void delete(Long id) {
        clientRepository.deleteById(id);
    }

    public NewClientRequest getClientRequestById(Long id) {
        return mapper.toNewClientRequest(clientRepository.findById(id)
                .orElseThrow(() -> new EntityNotFound(String.format("Client with id %s is not found", id))));
    }
}
