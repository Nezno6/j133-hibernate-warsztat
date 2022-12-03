package pl.sda.j133.hibernate.warsztat.komendy;

import pl.sda.j133.hibernate.warsztat.DataAccessObject;
import pl.sda.j133.hibernate.warsztat.model.SerwisPojazdu;

import java.util.Optional;

public class KomendaZnajdzSerwisPojazdu implements Komenda {
    private final DataAccessObject<SerwisPojazdu> dataAccessObject;

    public KomendaZnajdzSerwisPojazdu() {
        this.dataAccessObject = new DataAccessObject<>();
    }

    @Override
    public String getKomenda() {
        return "znajdz serwis";
    }

    @Override
    public void obsluga() {
        System.out.println("Podaj id serwisu pojazdu");
        String idString = Komenda.scanner.nextLine();
        Long idSerwisPojazdu = Long.parseLong(idString);

        Optional<SerwisPojazdu> serwisPojazduOptional = dataAccessObject.find(SerwisPojazdu.class, idSerwisPojazdu);
        if (serwisPojazduOptional.isEmpty()) {
            System.err.println("Serwis nie istnieje");
        } else {
            System.out.println(serwisPojazduOptional.get());
        }
    }
}
