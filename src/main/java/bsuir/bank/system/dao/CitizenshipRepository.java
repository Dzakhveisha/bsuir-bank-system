package bsuir.bank.system.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bsuir.bank.system.model.Citizenship;

@Repository
public interface CitizenshipRepository extends JpaRepository<Citizenship, Long> {
}
