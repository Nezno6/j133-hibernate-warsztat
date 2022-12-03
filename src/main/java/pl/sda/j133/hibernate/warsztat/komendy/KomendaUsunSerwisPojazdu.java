package pl.sda.j133.hibernate.warsztat.komendy;

import pl.sda.j133.hibernate.warsztat.DataAccessObject;
import pl.sda.j133.hibernate.warsztat.model.SerwisPojazdu;

public class KomendaUsunSerwisPojazdu implements Komenda {
    private final DataAccessObject<SerwisPojazdu> dataAccessObject;

    public KomendaUsunSerwisPojazdu() {
        this.dataAccessObject = new DataAccessObject<>();
    }

    @Override
    public String getKomenda() {
        return "usun serwis pojazdu";
    }

    @Override
    public void obsluga() {
        System.out.println("Podaj id usuwanego serwisu pojazdu: ");
        String idString = Komenda.scanner.nextLine();
        Long id = Long.parseLong(idString);

        if (dataAccessObject.delete(SerwisPojazdu.class, id)) {
            System.out.println("Usunieto Serwis pojazdu");
        } else {
            System.err.println("Nie udalo sie usunac Serwisu pojazdu");
        }
    }
}
