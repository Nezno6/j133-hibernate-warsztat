package pl.sda.j133.hibernate.warsztat.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Mechanik {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT
    private Long id;
    private String imie;
    private String kwalifikacja;
    private String specializacja;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "mechanik")
    private Set<SerwisPojazdu> zrealizowaneSerwisy;


}
