package pl.sda.j133.hibernate.warsztat.komendy;

import pl.sda.j133.hibernate.warsztat.DataAccessObject;
import pl.sda.j133.hibernate.warsztat.model.Mechanik;

public class KomendaAktualizujMechanik implements Komenda {
    private final DataAccessObject<Mechanik> dataAccessObject;

    public KomendaAktualizujMechanik() {
        this.dataAccessObject = new DataAccessObject<>();
    }

    @Override
    public String getKomenda() {
        return "aktualizuj mechanik";
    }

    @Override
    public void obsluga() {
        System.out.println("Podaj id mechanika");
        String idString = Komenda.scanner.nextLine();
        Long id = Long.parseLong(idString);

        if (!dataAccessObject.exists(Mechanik.class, id)) {
            System.err.println("Błąd, mechanik o takim id nie istnieje!");
            return;
        }

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
                .id(id)
                .build();

        dataAccessObject.update(Mechanik.class, id, mechanik);
    }
}
