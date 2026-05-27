package es.uah.agenda.modelo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CitaTest {

    private Contacto c1;
    private LocalDateTime base;

    @BeforeEach
    void setUp() {
        c1 = new Contacto("Ana", "+34600111222", "ana@uah.es", "dir");
        base = LocalDateTime.of(2026, 5, 1, 10, 0);
    }

    @Test
    void creacionValida() {
        Cita cita = new Cita(base, Duration.ofHours(1), "Sala A", List.of(c1));
        assertEquals(base, cita.getFechaHora());
        assertEquals(Duration.ofHours(1), cita.getDuracion());
        assertEquals(1, cita.getParticipantes().size());
    }

    @Test
    void duracionNoPositivaDebeFallar() {
        assertThrows(IllegalArgumentException.class,
            () -> new Cita(base, Duration.ZERO, "Sala", List.of()));
        assertThrows(IllegalArgumentException.class,
            () -> new Cita(base, Duration.ofMinutes(-30), "Sala", List.of()));
    }

    @Test
    void conflictoDeSolapamientoParcial() {
        Cita a = new Cita(base, Duration.ofHours(2), "S1", List.of());
        Cita b = new Cita(base.plusHours(1), Duration.ofHours(2), "S2", List.of());
        assertTrue(a.tieneConflictoCon(b));
        assertTrue(b.tieneConflictoCon(a));
    }

    @Test
    void sinConflictoAdyacentes() {
        Cita a = new Cita(base, Duration.ofHours(1), "S1", List.of());
        Cita b = new Cita(base.plusHours(1), Duration.ofHours(1), "S2", List.of());
        assertFalse(a.tieneConflictoCon(b),
            "Fin exacto = inicio siguiente NO debe ser conflicto (intervalos semi-abiertos)");
    }

    @Test
    void sinConflictoSeparadas() {
        Cita a = new Cita(base, Duration.ofHours(1), "S1", List.of());
        Cita b = new Cita(base.plusHours(3), Duration.ofHours(1), "S2", List.of());
        assertFalse(a.tieneConflictoCon(b));
    }

    @Test
    void noConflictoConsigoMismaNiConNull() {
        Cita a = new Cita(base, Duration.ofHours(1), "S1", List.of());
        assertFalse(a.tieneConflictoCon(a));
        assertFalse(a.tieneConflictoCon(null));
    }

    @Test
    void añadirParticipanteEvitaDuplicados() {
        Cita cita = new Cita(base, Duration.ofHours(1), "S1", List.of());
        assertTrue(cita.añadirParticipante(c1));
        assertFalse(cita.añadirParticipante(c1));
        assertEquals(1, cita.getParticipantes().size());
    }

    @Test
    void ordenNaturalPorFecha() {
        Cita a = new Cita(base.plusHours(5), Duration.ofHours(1), "S1", List.of());
        Cita b = new Cita(base, Duration.ofHours(1), "S2", List.of());
        assertTrue(a.compareTo(b) > 0);
    }
}
