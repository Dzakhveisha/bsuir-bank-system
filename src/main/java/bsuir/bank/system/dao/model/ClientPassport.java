package bsuir.bank.system.dao.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "passports")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClientPassport {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    @Column(name = "passports_id")
    private Long id;

    @Column(name = "passport_series")
    private String series;

    @Column(name = "passport_number")
    private String number;

    @Column(name = "passport_date_of_issue")
    private LocalDate issuedDate;

    @Column(name = "passport_issued_by")
    private String issuedBy;

    @Column(name = "passport_identification_number")
    private String idNumber;

    @Column(name = "passport_place_of_birth")
    private String birthPlace;

    @ManyToOne
    @JoinColumn(name = "passport_city_of_birth_id")
    private City cityOfBirth;

    @ManyToOne
    @JoinColumn(name = "passport_city_of_registration_id")
    private City registrationCity;
}
