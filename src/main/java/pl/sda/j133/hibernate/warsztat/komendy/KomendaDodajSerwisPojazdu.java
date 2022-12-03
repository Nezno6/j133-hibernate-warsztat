package pl.sda.j133.hibernate.warsztat.komendy;

import pl.sda.j133.hibernate.warsztat.DataAccessObject;
import pl.sda.j133.hibernate.warsztat.model.Mechanik;
import pl.sda.j133.hibernate.warsztat.model.Pojazd;
import pl.sda.j133.hibernate.warsztat.model.SerwisPojazdu;

import java.util.Optional;

public class KomendaDodajSerwisPojazdu implements Komenda {

    private final DataAccessObject<Mechanik> dataAccessObjectMechanik;
    private final DataAccessObject<Pojazd> dataAccessObjectPojazd;
    private final DataAccessObject<SerwisPojazdu> dataAccessObject;


    public KomendaDodajSerwisPojazdu() {
        this.dataAccessObject = new DataAccessObject<>();
        this.dataAccessObjectPojazd = new DataAccessObject<>();
        this.dataAccessObjectMechanik = new DataAccessObject<>();
    }

    @Override
    public String getKomenda() {
        return "dodaj serwis pojazdu";
    }

    @Override
    public void obsluga() {
        System.out.println("Podaj id serwisowanego pojazdu");
        String idString = Komenda.scanner.nextLine();
        Long idPojazd = Long.parseLong(idString);

        Optional<Pojazd> pojazdOptional = dataAccessObjectPojazd.find(Pojazd.class, idPojazd);
        if (pojazdOptional.isEmpty()) {
            System.err.println("Pojazd nie istnieje");
            return;
        }

        System.out.println("Podaj id mechanika pojazdu");
        String idMechanikaString = Komenda.scanner.nextLine();
        Long idMechanik = Long.parseLong(idMechanikaString);

        Optional<Mechanik> mechanikOptional = dataAccessObjectMechanik.find(Mechanik.class, idMechanik);
        if (mechanikOptional.isEmpty()) {
            System.err.println("Mechanik nie istnieje");
            return;
        }

        System.out.println("Podaj opis serwisu:");
        String opis = Komenda.scanner.nextLine();

        SerwisPojazdu serwisPojazdu = SerwisPojazdu
                .builder()
                .mechanik(mechanikOptional.get())
                .pojazd(pojazdOptional.get())
                .opis(opis)
                .build();

        dataAccessObject.insert(serwisPojazdu);
        System.out.println("Dodano serwis");
    }
}
