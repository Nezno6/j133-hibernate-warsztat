package pl.sda.j133.hibernate.warsztat;

import pl.sda.j133.hibernate.warsztat.komendy.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Komenda> listaKomend = List.of(
                new KomendaDodajPojazd(),
                new KomendaDodajMechanik(),
                new KomendaDodajSerwisPojazdu(),

                new KomendaListaPojazd(),
                new KomendaListaMechanik(),
                new KomendaListaSerwisPojazdu(),

                new KomendaZnajdzPojazd(),
                new KomendaZnajdzMechanik(),
                new KomendaZnajdzSerwisPojazdu(),

                new KomendaUsunPojazd(),
                new KomendaUsunMechanik(),
                new KomendaUsunSerwisPojazdu(),

                new KomendaAktualizujMechanik(),
                new KomendaAktualizujPojazd(),
                new KomendaZakonczSerwisPojazdu()
        );
        System.out.println("Lista dostepnych komend:");
        listaKomend.forEach(komenda -> System.out.println(komenda.getKomenda()));

        System.out.println("Podaj komende");
        String komenda = Komenda.scanner.nextLine();

        listaKomend
                .stream()
                .filter(dostepnaKomenda -> dostepnaKomenda.getKomenda().equalsIgnoreCase(komenda))
                .findFirst().ifPresent(Komenda::obsluga);
    }
}
