package es.uah.agenda.modelo;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TareaSeguimientoTest {

    private Contacto resp() {
        return new Contacto("Ana", "+34600111222", "ana@uah.es", "d");
    }

    @Test
    void creacionValida() {
        TareaSeguimiento ts = new TareaSeguimiento(
            "Entregar informe", Prioridad.ALTA, Estado.PENDIENTE,
            LocalDate.now().plusDays(3), List.of(resp())
        );
        assertEquals(1, ts.getResponsables().size());
        assertFalse(ts.estaVencida());
    }

    @Test
    void tareaPendienteVencidaSiFechaEnPasado() {
        TareaSeguimiento ts = new TareaSeguimiento(
            "X", Prioridad.MEDIA, Estado.PENDIENTE,
            LocalDate.now().minusDays(1), List.of()
        );
        assertTrue(ts.estaVencida());
    }

    @Test
    void tareaCompletadaNoEstaVencidaAunqueFechaPasada() {
        TareaSeguimiento ts = new TareaSeguimiento(
            "X", Prioridad.MEDIA, Estado.COMPLETADA,
            LocalDate.now().minusDays(5), List.of()
        );
        assertFalse(ts.estaVencida());
    }

    @Test
    void tareaCanceladaNoEstaVencida() {
        TareaSeguimiento ts = new TareaSeguimiento(
            "X", Prioridad.MEDIA, Estado.CANCELADA,
            LocalDate.now().minusDays(5), List.of()
        );
        assertFalse(ts.estaVencida());
    }

    @Test
    void asignacionResponsablesEvitaDuplicados() {
        Contacto c = resp();
        TareaSeguimiento ts = new TareaSeguimiento(
            "X", Prioridad.BAJA, Estado.PENDIENTE, LocalDate.now().plusDays(1), List.of()
        );
        assertTrue(ts.asignarResponsable(c));
        assertFalse(ts.asignarResponsable(c));
        assertEquals(1, ts.getResponsables().size());
    }

    @Test
    void fechaLimiteNulaDebeFallar() {
        assertThrows(NullPointerException.class, () -> new TareaSeguimiento(
            "X", Prioridad.BAJA, Estado.PENDIENTE, null, List.of()
        ));
    }
}
