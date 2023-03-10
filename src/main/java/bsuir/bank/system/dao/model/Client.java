package bsuir.bank.system.dao.model;

import static org.hibernate.annotations.CascadeType.DELETE;
import static org.hibernate.annotations.CascadeType.SAVE_UPDATE;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.OnDelete;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @OneToOne
    @JoinColumn(name = "client_passport_id")
    @Cascade({DELETE, SAVE_UPDATE})
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
    @JoinColumn(name = "client_disability_id")
    private ClientDisability disability;

    @Column(name = "client_monthly_earnings")
    private BigDecimal monthlySalary;

    @Column(name = "client_is_pensioner")
    private Boolean isPensioner;

    @Column(name = "client_fact_address")
    private String factAddress;

    @ManyToOne
    @JoinColumn(name = "client_fact_city_id")
    private City factCity;

    @ManyToOne
    @JoinColumn(name = "client_citizenship_id")
    private Citizenship citizenship;
}
