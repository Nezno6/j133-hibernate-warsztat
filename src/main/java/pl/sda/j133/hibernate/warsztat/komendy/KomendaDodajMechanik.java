package pl.sda.j133.hibernate.warsztat.komendy;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.sda.j133.hibernate.warsztat.DataAccessObject;
import pl.sda.j133.hibernate.warsztat.HibernateUtil;
import pl.sda.j133.hibernate.warsztat.model.Mechanik;

public class KomendaDodajMechanik implements Komenda {
    private final DataAccessObject<Mechanik> dataAccessObject;

    public KomendaDodajMechanik() {
        this.dataAccessObject = new DataAccessObject<>();
    }

    @Override
    public String getKomenda() {
        return "dodaj mechanik";
    }

    @Override
    public void obsluga() {
        System.out.println("Podaj imie mechanika");
        String imie = Komenda.scanner.nextLine();

        System.out.println("Podaj kwalifikacje mechanika");
        String kwalifikacja = Komenda.scanner.nextLine();

        System.out.println("Podaj specializacje mechanika");
        String specializacja = Komenda.scanner.nextLine();

        Mechanik mechanik = Mechanik
                .builder()
                .imie(imie)
                .kwalifikacja(kwalifikacja)
                .specializacja(specializacja)
                .build();

        dataAccessObject.insert(mechanik);
    }
}
