package bsuir.bank.system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bsuir.bank.system.dao.ClientRepository;
import bsuir.bank.system.dao.model.Client;
import bsuir.bank.system.service.exception.EntityNotFound;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClientService {

    @Autowired
    private final ClientRepository repository;

    public List<Client> getAll() {
        return repository.findAll();
    }

    public Client create(Client newClient) {
        return repository.save(newClient);
    }

    public Client get(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFound(String.format("Client with id %s is not found", id)));
    }

    public Client update(Client newClient, Long id) {
        repository.findById(id)
                .orElseThrow(() -> new EntityNotFound(String.format("Client with id %s is not found", id)));
        newClient.setId(id);
        return repository.save(newClient);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
