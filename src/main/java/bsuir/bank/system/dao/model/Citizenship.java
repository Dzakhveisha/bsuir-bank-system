package bsuir.bank.system.dao.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "citizenship")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Citizenship {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "citizenship_id")
    private Long id;

    @Column(name = "citizenship_country")
    private String country;
}
