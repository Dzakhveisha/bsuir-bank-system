package bsuir.bank.system.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bsuir.bank.system.model.ClientDisability;

@Repository
public interface DisabilityRepository extends JpaRepository<ClientDisability, Long> {
}
