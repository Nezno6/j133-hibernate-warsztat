package pl.sda.j133.hibernate.warsztat.komendy;

import pl.sda.j133.hibernate.warsztat.DataAccessObject;
import pl.sda.j133.hibernate.warsztat.model.Pojazd;

public class KomendaDodajPojazd implements Komenda {
    private final DataAccessObject<Pojazd> dataAccessObject;

    public KomendaDodajPojazd() {
        this.dataAccessObject = new DataAccessObject<>();
    }

    @Override
    public String getKomenda() {
        return "dodaj pojazd";
    }

    @Override
    public void obsluga() {
        System.out.println("Podaj marke pojazdu");
        String marka = Komenda.scanner.nextLine();

        System.out.println("Podaj model pojazdu");
        String model = Komenda.scanner.nextLine();

        System.out.println("Podaj vin pojazdu");
        String vin = Komenda.scanner.nextLine();

        System.out.println("Podaj nrRej pojazdu");
        String nrRej = Komenda.scanner.nextLine();

        Pojazd pojazd = Pojazd
                .builder()
                .marka(marka)
                .model(model)
                .nrRej(nrRej)
                .vin(vin)
                .build();

        dataAccessObject.insert(pojazd);
    }
}
