package es.uah.agenda.modelo;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CitaTrabajoTest {

    @Test
    void gestionDeTemas() {
        CitaTrabajo ct = new CitaTrabajo(
            LocalDateTime.of(2026, 5, 1, 9, 0),
            Duration.ofMinutes(90),
            "Sala Reuniones",
            List.of(),
            List.of("Q2 Review")
        );
        assertTrue(ct.añadirTema("Roadmap H2"));
        assertFalse(ct.añadirTema("   "));
        assertFalse(ct.añadirTema(null));
        assertEquals(2, ct.getAgendaTemas().size());
        assertTrue(ct.eliminarTema("Q2 Review"));
    }

    @Test
    void listaDeTemasEsInmutable() {
        CitaTrabajo ct = new CitaTrabajo(
            LocalDateTime.now(), Duration.ofHours(1), "S", List.of(), List.of("t1")
        );
        assertThrows(UnsupportedOperationException.class,
            () -> ct.getAgendaTemas().add("hack"));
    }

    @Test
    void duracionEstimadaCoincideConDuracion() {
        CitaTrabajo ct = new CitaTrabajo(
            LocalDateTime.now(), Duration.ofMinutes(45), "S", List.of(), List.of()
        );
        assertEquals(Duration.ofMinutes(45), ct.getDuracionEstimada());
    }
}
