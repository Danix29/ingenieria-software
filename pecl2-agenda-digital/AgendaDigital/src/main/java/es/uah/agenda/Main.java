package es.uah.agenda;

import es.uah.agenda.modelo.*;
import java.time.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Contacto ana = new Contacto("Ana", "+34600111222", "ana@uah.es", "C/ Mayor 1");
        System.out.println(ana);

        Cita c1 = new Cita(LocalDateTime.of(2026, 5, 1, 10, 0),
                           Duration.ofHours(2), "Sala A", List.of(ana));
        Cita c2 = new Cita(LocalDateTime.of(2026, 5, 1, 11, 0),
                           Duration.ofHours(1), "Sala B", List.of());
        System.out.println("¿Conflicto? " + c1.tieneConflictoCon(c2));  // true
    }
}