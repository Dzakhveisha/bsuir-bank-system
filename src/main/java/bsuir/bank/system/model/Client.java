package bsuir.bank.system.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "clients")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "client_id")
    private Long id;

    @Column(name = "client_first_name")
    private String firstName;

    @Column(name = "client_last_name")
    private String lastName;

    @Column(name = "client_middle_name")
    private String middleName;

    @Column(name = "client_birth_date")
    private LocalDate birthDate;

    @Column(name = "client_sex")
    private char gender;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_passport_id")
    private ClientPassport passport;

    @Column(name = "client_mobile_phone_number")
    private String mobilePhone;

    @Column(name = "client_home_phone_number")
    private String homeNumber;

    @Column(name = "client_email")
    private String email;

    @ManyToOne
    @JoinColumn(name = "client_marital_status_id")
    private MaritalStatus maritalStatus;

    @ManyToOne
    @JoinColumn(name = "client_place_of_residence_id")
    private Address placeOfResidence;

    @ManyToOne
    @JoinColumn(name = "client_disability_id")
    private ClientDisability disability;

    @Column(name = "client_monthly_earnings")
    private BigDecimal monthlySalary;

    @Column(name = "client_is_pensioner")
    private Boolean isPensioner;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "citizenship_id")
    private List<Citizenship> citizenship;
}
