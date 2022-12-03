package pl.sda.j133.hibernate.warsztat.komendy;

import pl.sda.j133.hibernate.warsztat.DataAccessObject;
import pl.sda.j133.hibernate.warsztat.model.Mechanik;

import java.util.List;

public class KomendaListaMechanik implements Komenda {

    private final DataAccessObject<Mechanik> dataAccessObject;

    public KomendaListaMechanik() {
        this.dataAccessObject = new DataAccessObject<>();
    }

    @Override
    public String getKomenda() {
        return "lista mechanik";
    }

    @Override
    public void obsluga() {
        List<Mechanik> mechanicy = dataAccessObject.findAll(Mechanik.class);
        mechanicy.forEach(System.out::println);
    }
}
