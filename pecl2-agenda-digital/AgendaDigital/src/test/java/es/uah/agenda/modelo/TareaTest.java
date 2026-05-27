package es.uah.agenda.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TareaTest {

    @Test
    void creacionValida() {
        Tarea t = new Tarea("Revisar PR", Prioridad.ALTA, Estado.PENDIENTE);
        assertEquals(Prioridad.ALTA, t.getPrioridad());
        assertEquals(Estado.PENDIENTE, t.getEstado());
    }

    @Test
    void completarCambiaEstado() {
        Tarea t = new Tarea("X", Prioridad.BAJA, Estado.EN_PROGRESO);
        t.completar();
        assertEquals(Estado.COMPLETADA, t.getEstado());
    }

    @Test
    void descripcionVaciaDebeFallar() {
        assertThrows(IllegalArgumentException.class,
            () -> new Tarea("", Prioridad.BAJA, Estado.PENDIENTE));
    }

    @Test
    void prioridadNulaDebeFallar() {
        assertThrows(NullPointerException.class,
            () -> new Tarea("desc", null, Estado.PENDIENTE));
    }

    @Test
    void ordenacionPorPrioridadDescendente() {
        List<Tarea> tareas = new ArrayList<>(List.of(
            new Tarea("baja", Prioridad.BAJA, Estado.PENDIENTE),
            new Tarea("critica", Prioridad.CRITICA, Estado.PENDIENTE),
            new Tarea("media", Prioridad.MEDIA, Estado.PENDIENTE),
            new Tarea("alta", Prioridad.ALTA, Estado.PENDIENTE)
        ));
        Collections.sort(tareas);
        assertEquals(Prioridad.CRITICA, tareas.get(0).getPrioridad());
        assertEquals(Prioridad.ALTA,    tareas.get(1).getPrioridad());
        assertEquals(Prioridad.MEDIA,   tareas.get(2).getPrioridad());
        assertEquals(Prioridad.BAJA,    tareas.get(3).getPrioridad());
    }
}
