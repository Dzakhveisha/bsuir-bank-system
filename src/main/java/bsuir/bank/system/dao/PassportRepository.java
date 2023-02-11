package bsuir.bank.system.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bsuir.bank.system.dao.model.ClientPassport;

@Repository
public interface PassportRepository extends JpaRepository<ClientPassport, Long> {
}
