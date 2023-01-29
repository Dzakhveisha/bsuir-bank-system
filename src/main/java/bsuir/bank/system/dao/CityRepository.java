package bsuir.bank.system.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bsuir.bank.system.model.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
}
