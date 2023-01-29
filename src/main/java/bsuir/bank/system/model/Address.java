package bsuir.bank.system.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "address")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    @Column(name = "address_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "address_city_Id")
    private City city;

    @Column(name = "address_street")
    private String street;

    @Column(name = "address_building_number")
    private String buildingNumber;

    @Column(name = "address_flat_number")
    private Long flatNumber;
}
