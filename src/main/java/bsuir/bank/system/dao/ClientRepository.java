package bsuir.bank.system.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bsuir.bank.system.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
