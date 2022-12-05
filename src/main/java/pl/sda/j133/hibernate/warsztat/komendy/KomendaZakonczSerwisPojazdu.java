package pl.sda.j133.hibernate.warsztat.komendy;

import pl.sda.j133.hibernate.warsztat.DataAccessObject;
import pl.sda.j133.hibernate.warsztat.model.SerwisPojazdu;

import java.time.LocalDateTime;
import java.util.Optional;

public class KomendaZakonczSerwisPojazdu implements Komenda {
    private final DataAccessObject<SerwisPojazdu> dataAccessObject;

    public KomendaZakonczSerwisPojazdu() {
        this.dataAccessObject = new DataAccessObject<>();
    }

    @Override
    public String getKomenda() {
        return "zakoncz serwis";
    }

    @Override
    public void obsluga() {
        System.out.println("Podaj id serwisu");
        String idString = Komenda.scanner.nextLine();
        Long id = Long.parseLong(idString);

        Optional<SerwisPojazdu> serwisPojazduOptional = dataAccessObject.find(SerwisPojazdu.class, id);
        if (serwisPojazduOptional.isEmpty()) {
            System.err.println("Błąd, zlecenie serwisu o takim id nie istnieje!");
            return;
        }
        SerwisPojazdu orginalnySerwisPojazdu = serwisPojazduOptional.get();

        System.out.println("Podaj zrealizowane czynnosci");
        String czynnosci = Komenda.scanner.nextLine();

        System.out.println("Podaj koszt serwisu");
        String kosztString = Komenda.scanner.nextLine();
        Double koszt = Double.parseDouble(kosztString);


        SerwisPojazdu serwisPojazdu = SerwisPojazdu
                .builder()
                .pojazd(orginalnySerwisPojazdu.getPojazd())
                .mechanik(orginalnySerwisPojazdu.getMechanik())
                .czasDodania(orginalnySerwisPojazdu.getCzasDodania())
                .opis(orginalnySerwisPojazdu.getOpis())
                .czasZrealizowania(LocalDateTime.now())
                .zrealizowanaCzynnosc(czynnosci)
                .koszt(koszt)
                .id(id)
                .build();

        dataAccessObject.update(SerwisPojazdu.class, id, serwisPojazdu);
    }
}
