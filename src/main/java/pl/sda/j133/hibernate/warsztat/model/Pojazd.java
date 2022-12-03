package pl.sda.j133.hibernate.warsztat.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pojazd {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT
    private Long id;
    private String marka;
    private String model;
    private String vin;
    private String nrRej;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "pojazd")
    private Set<SerwisPojazdu> serwisy;
}
